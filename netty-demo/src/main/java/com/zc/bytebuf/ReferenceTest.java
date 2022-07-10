package com.zc.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import lombok.extern.slf4j.Slf4j;

/**
 * ByteBuf内存回收根据引用计数的方式管理
 * <ul>
 *     <li>池化的回收方法是重新放入池子,等待下一次分配</li>
 *     <li>非池化的回收方法,如果是Heap结构缓冲,会被jvm垃圾回收器回收,如果是Direct类型,会调用本地方法释放外部内存</li>
 * </ul>
 *
 * @author 周超
 * @since 2022/7/10 17:26
 */
@Slf4j
public class ReferenceTest {
    public static void main(String[] args) {
        ByteBuf buffer = ByteBufAllocator.DEFAULT.buffer();
        log.info("after create:{}", buffer.refCnt());
        buffer.retain();
        log.info("after retain:{}", buffer.refCnt());
        buffer.release();
        log.info("after release:{}", buffer.refCnt());
        buffer.release();
        log.info("after release:{}", buffer.refCnt());
        buffer.retain();
        log.info("after retain:{}", buffer.refCnt());
    }
}
