package com.zc.util;

import com.zc.event.MyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author yeyu
 * @since 2021/12/11 6:12 下午
 */
@Component
public class EventListeners {
    @EventListener
    public void sendMessage(MyEvent event) {
        System.out.println(Thread.currentThread().getName());
        System.out.println("-----" + event);
    }
}
