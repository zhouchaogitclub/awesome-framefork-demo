package com.zc.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 周超
 * @since 2022/7/10 21:49
 */
@Slf4j
public class IntegerInBoundHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Integer msg1 = (Integer) msg;
        log.info("打印出一个整数:{}", msg1);
        super.channelRead(ctx, msg);
    }
}
