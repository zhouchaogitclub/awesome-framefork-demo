package com.zc.aio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author yeyu
 * @since 2022/7/9 14:19
 */
public class AsyncIODemo {
    public static void main(String[] args) throws IOException {
        AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(Paths.get("a.txt"), StandardOpenOption.READ);
        ByteBuffer buffer = ByteBuffer.allocate(40);
        fileChannel.read(buffer, 0, buffer, new CompletionHandler<Integer, ByteBuffer>() {
            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                attachment.flip();
                byte[] bytes = new byte[attachment.limit()];
                attachment.get(bytes);
                System.out.println("read " + result + " byte");
                System.out.println(new String(bytes));
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {
                exc.printStackTrace();
            }
        });
        System.in.read();
    }

}
