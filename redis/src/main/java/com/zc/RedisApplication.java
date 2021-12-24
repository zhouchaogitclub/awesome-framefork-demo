package com.zc;

import com.zc.event.MyEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.instrument.Instrumentation;

/**
 * @author yeyu
 * @since 2021/8/14 9:22 下午
 */
@SpringBootApplication
@RestController
@EnableAsync
public class RedisApplication implements Serializable {
    @Resource
    private StringRedisTemplate template;
    @Resource
    private ApplicationEventPublisher publisher;


    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("main");
        System.out.println(agentArgs);
    }

    @GetMapping("hello")
    public Long index() {
        publisher.publishEvent(new MyEvent(this));
        return template.opsForValue().increment("count", 1);
    }

    public static void main(String[] args) {
        SpringApplication.run(RedisApplication.class, args);
    }
}
