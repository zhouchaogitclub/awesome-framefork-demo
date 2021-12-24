package com.zc.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author yeyu
 * @since 2021/12/11 6:10 下午
 */
public class MyEvent extends ApplicationEvent {
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public MyEvent(Object source) {
        super(source);
    }
}
