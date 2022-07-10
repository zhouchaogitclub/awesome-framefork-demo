package com.zc.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * 将ByteBuf缓冲区中的数据转换成一个个Integer
 *
 * @author 周超
 * @since 2022/7/10 21:33
 */
@Slf4j
public class Byte2IntegerReplayingDecoder extends ReplayingDecoder<Integer> {
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        int i = byteBuf.readInt();
        log.info("解码出一个整数:{}", i);
        list.add(i);
    }
}
