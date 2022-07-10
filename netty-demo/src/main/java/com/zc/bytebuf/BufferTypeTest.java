package com.zc.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.PooledByteBufAllocator;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author 周超
 * @since 2022/7/10 17:33
 */
@Slf4j
public class BufferTypeTest {
    @Test
    public void testHeapBuffer() {
        ByteBuf buffer = PooledByteBufAllocator.DEFAULT.heapBuffer();
        buffer.writeBytes("hello world".getBytes());
        if (buffer.hasArray()) { // 判断是否是Heap类型的缓冲区
            log.info(new String(buffer.array(), buffer.arrayOffset() + buffer.readerIndex(), buffer.readableBytes()));
        }
        buffer.release();
    }

    @Test
    public void testDirectBuffer() {
        ByteBuf buffer = ByteBufAllocator.DEFAULT.directBuffer();
        buffer.writeBytes("hello world".getBytes());
        if (!buffer.hasArray()) {
            int length = buffer.readableBytes();
            byte[] array = new byte[length];
            buffer.getBytes(buffer.readerIndex(), array);
            log.info(new String(array));
        }
        buffer.release();
    }
}
