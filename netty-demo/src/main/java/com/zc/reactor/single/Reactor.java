package com.zc.reactor.single;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Set;

/**
 * 单线程reactor器,Reactor反应器和Handler处理器在同一个线程中执行
 *
 * @author 周超
 * @since 2022/7/10 9:21
 */
@Slf4j
public class Reactor implements Runnable {
    private final Selector selector;
    private final ServerSocketChannel serverSocketChannel;

    public Reactor() throws IOException {
        selector = Selector.open();
        serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.socket().bind(new InetSocketAddress("127.0.0.1", 9000));
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT, new AcceptHandler());
    }

    public static void main(String[] args) throws IOException {
        new Thread(new Reactor()).start();
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

    class AcceptHandler implements Runnable {

        @Override
        public void run() {
            try {
                SocketChannel socketChannel = serverSocketChannel.accept();
                if (socketChannel != null) {
                    new IOHandler(socketChannel);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    class IOHandler implements Runnable {
        private final SocketChannel socketChannel;
        private final SelectionKey selectionKey;

        public IOHandler(SocketChannel socketChannel) throws IOException {
            this.socketChannel = socketChannel;
            socketChannel.configureBlocking(false);
            selectionKey = socketChannel.register(selector, SelectionKey.OP_READ, this);
        }

        @Override
        public void run() {
            // 处理io事件
            ByteBuffer allocate = ByteBuffer.allocate(60);
            try {
                while (socketChannel.read(allocate) > 0) {
                    log.info(new String(allocate.array(), 0, allocate.position()));
                }
                selectionKey.cancel();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
