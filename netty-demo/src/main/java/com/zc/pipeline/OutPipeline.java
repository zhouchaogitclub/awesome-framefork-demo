package com.zc.pipeline;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.channel.embedded.EmbeddedChannel;
import lombok.extern.slf4j.Slf4j;

/**
 * pipeline出站处理流程
 * <p>
 * 流动次序：从后向前,先添加的后执行
 *
 * @author 周超
 * @since 2022/7/10 16:53
 */
@Slf4j
public class OutPipeline {
    public static void main(String[] args) {
        EmbeddedChannel channel = new EmbeddedChannel(new ChannelInitializer<EmbeddedChannel>() {
            @Override
            protected void initChannel(EmbeddedChannel ch) {
                ch.pipeline().addLast(new SimpleOutHandler1()).addLast(new SimpleOutHandler2()).addLast(new SimpleOutHandler3());
            }
        });
        channel.writeOutbound("hello");
    }

    static class SimpleOutHandler1 extends ChannelOutboundHandlerAdapter {
        @Override
        public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
            log.info("出站处理器1,被回调");
            super.write(ctx, msg, promise);
        }
    }

    static class SimpleOutHandler2 extends ChannelOutboundHandlerAdapter {
        @Override
        public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
            log.info("出站处理器2,被回调");
            super.write(ctx, msg, promise);
        }
    }

    static class SimpleOutHandler3 extends ChannelOutboundHandlerAdapter {
        @Override
        public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
            log.info("出站处理器3,被回调");
            super.write(ctx, msg, promise);
        }
    }
}
