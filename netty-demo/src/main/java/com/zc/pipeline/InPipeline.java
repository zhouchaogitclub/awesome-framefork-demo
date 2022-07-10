package com.zc.pipeline;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.embedded.EmbeddedChannel;
import lombok.extern.slf4j.Slf4j;

/**
 * pipeline入站处理流程
 * <p>
 * 流动次序：从前向后,先添加的先执行
 *
 * @author 周超
 * @since 2022/7/10 16:45
 */
@Slf4j
public class InPipeline {
    public static void main(String[] args) {
        EmbeddedChannel channel = new EmbeddedChannel(new ChannelInitializer<EmbeddedChannel>() {
            @Override
            protected void initChannel(EmbeddedChannel ch) {
                ch.pipeline().addLast(new SimpleHandler1()).addLast(new SimpleHandler2()).addLast(new SimpleHandler3());
            }
        });
        channel.writeInbound("hello");
        channel.writeInbound("world");
    }

    static class SimpleHandler1 extends ChannelInboundHandlerAdapter {
        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            log.info("入站处理器1:被回调");
            super.channelRead(ctx, msg);
        }
    }

    static class SimpleHandler2 extends ChannelInboundHandlerAdapter {
        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            log.info("入站处理器2:被回调");
            // 去除该行,会短路流水线,后面的handler不会执行
//            super.channelRead(ctx, msg);
            // handler热拔插的体现,可以随时添加或者删除handler
            ctx.pipeline().remove(this);
        }
    }

    static class SimpleHandler3 extends ChannelInboundHandlerAdapter {
        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            log.info("入站处理器3:被回调");
            super.channelRead(ctx, msg);
        }
    }
}
