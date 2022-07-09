package com.zc.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author yeyu
 * @since 2021/12/24 10:40 PM
 */
@Component
@Slf4j
public final class RedisUtils {
    private static StringRedisTemplate template;

    @Autowired
    public void setTemplate(StringRedisTemplate template) {
        RedisUtils.template = template;
    }

    public static void set(String key, String value) {
        template.opsForValue().set(key, value);
    }

    public static String get(String key) {
        return template.opsForValue().get(key);
    }
}