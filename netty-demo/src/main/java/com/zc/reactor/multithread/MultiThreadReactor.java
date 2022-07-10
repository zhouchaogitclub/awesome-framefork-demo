package com.zc.reactor.multithread;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 周超
 * @since 2022/7/10 10:20
 */
@Slf4j
public class MultiThreadReactor {
    private final ServerSocketChannel serverSocketChannel;
    private final Selector[] selectors = new Selector[2];

    public MultiThreadReactor() throws IOException {
        selectors[0] = Selector.open();
        selectors[1] = Selector.open();
        serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.socket().bind(new InetSocketAddress("127.0.0.1", 9000));
        serverSocketChannel.register(selectors[0], SelectionKey.OP_ACCEPT, new AcceptHandler());
    }

    static class SubReactor implements Runnable {
        private final Selector selector;

        public SubReactor(Selector selector) {
            this.selector = selector;
        }

        @Override
        public void run() {
            try {
                while (!Thread.interrupted()) {
                    selector.select();
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();
                    for (SelectionKey selectionKey : selectionKeys) {
                        dispatch(selectionKey);
                    }
                    selectionKeys.clear();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        void dispatch(SelectionKey key) {
            Runnable attachment = (Runnable) key.attachment();
            if (attachment != null) {
                attachment.run();
            }
        }
    }

    private void startReactor() {
        // 第一个反应器负责接受和分派io事件
        new Thread(new SubReactor(selectors[0])).start();
        // 第二个反应器负责处理io事件
        new Thread(new SubReactor(selectors[1])).start();
    }

    public static void main(String[] args) throws IOException {
        MultiThreadReactor multiThreadReactor = new MultiThreadReactor();
        multiThreadReactor.startReactor();
    }

    class AcceptHandler implements Runnable {
        @Override
        public void run() {
            try {
                SocketChannel socketChannel = serverSocketChannel.accept();
                if (socketChannel != null) {
                    new MultiThreadIOHandler(selectors[1], socketChannel);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static class MultiThreadIOHandler implements Runnable {
        private final SocketChannel socketChannel;
        private final SelectionKey selectionKey;
        private static final ExecutorService pool = Executors.newFixedThreadPool(4);

        public MultiThreadIOHandler(Selector selector, SocketChannel socketChannel) throws IOException {
            this.socketChannel = socketChannel;
            socketChannel.configureBlocking(false);
            selector.wakeup();
            selectionKey = socketChannel.register(selector, SelectionKey.OP_READ, this);
        }

        @Override
        public void run() {
            // 处理io事件
            pool.execute(() -> {
                ByteBuffer allocate = ByteBuffer.allocate(60);
                try {
                    if (selectionKey.isReadable()) {
                        while (socketChannel.read(allocate) > 0) {
                            log.info(new String(allocate.array(), 0, allocate.position()));
                        }
                        selectionKey.cancel();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
