package com.zc.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.embedded.EmbeddedChannel;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author 周超
 * @since 2022/7/10 21:50
 */
public class Byte2IntegerDecoderTest {
    @Test
    public void testByte2IntegerDecoder() throws InterruptedException {
        EmbeddedChannel embeddedChannel = new EmbeddedChannel(new ChannelInitializer<EmbeddedChannel>() {
            @Override
            protected void initChannel(EmbeddedChannel ch) {
                ch.pipeline().addLast(new Byte2IntegerDecoder()).addLast(new IntegerInBoundHandler());
            }
        });
        for (int i = 0; i < 10; i++) {
            ByteBuf buffer = Unpooled.buffer();
            buffer.writeInt(i);
            embeddedChannel.writeInbound(buffer);
        }
        Thread.sleep(2000);
    }

    @Test
    public void testReplayingDecoder() throws InterruptedException {
        EmbeddedChannel embeddedChannel = new EmbeddedChannel(new ChannelInitializer<EmbeddedChannel>() {
            @Override
            protected void initChannel(EmbeddedChannel ch) {
                ch.pipeline().addLast(new Byte2IntegerReplayingDecoder()).addLast(new IntegerInBoundHandler());
            }
        });
        for (int i = 0; i < 10; i++) {
            ByteBuf buffer = Unpooled.buffer();
            buffer.writeInt(i);
            embeddedChannel.writeInbound(buffer);
        }
        Thread.sleep(2000);
    }
}