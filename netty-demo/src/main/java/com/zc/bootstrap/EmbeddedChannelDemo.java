package com.zc.bootstrap;

import com.zc.handler.InBoundCallChainLogHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.embedded.EmbeddedChannel;

/**
 * @author 周超
 * @since 2022/7/10 16:40
 */
public class EmbeddedChannelDemo {
    public static void main(String[] args) {
        EmbeddedChannel embeddedChannel = new EmbeddedChannel(new ChannelInitializer<EmbeddedChannel>() {
            @Override
            protected void initChannel(EmbeddedChannel ch) {
                ch.pipeline().addLast(new InBoundCallChainLogHandler());
            }
        });
        embeddedChannel.writeInbound("hello");
        embeddedChannel.flush();
        embeddedChannel.writeInbound("world");
        embeddedChannel.flush();
        embeddedChannel.close();
    }
}
