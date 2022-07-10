package com.zc.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 周超
 * @since 2022/7/10 17:19
 */
@Slf4j
public class BasicUsageDemo {
    public static void main(String[] args) {
        ByteBuf buffer = Unpooled.buffer(25);
        print(buffer);
        buffer.writeInt(10);
        print(buffer);
    }

    static void print(ByteBuf byteBuf) {
        log.info("=============================================");
        log.info("isReadable:{}", byteBuf.isReadable());
        log.info("readerIndex:{}", byteBuf.readerIndex());
        log.info("readableBytes:{}", byteBuf.readableBytes());
        log.info("isWritable:{}", byteBuf.isWritable());
        log.info("writerIndex:{}", byteBuf.writerIndex());
        log.info("writableBytes:{}", byteBuf.writableBytes());
        log.info("capacity:{}", byteBuf.capacity());
        log.info("maxCapacity:{}", byteBuf.maxCapacity());
        log.info("maxWritableBytes:{}", byteBuf.maxWritableBytes());
    }
}
