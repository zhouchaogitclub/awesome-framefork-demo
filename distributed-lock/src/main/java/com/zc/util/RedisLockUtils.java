package com.zc.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.time.Duration;

/**
 * @author yeyu
 * @since 2022/6/10 13:46
 */
@Component
public final class RedisLockUtils {
    private static StringRedisTemplate redisTemplate;

    public boolean tryLock(String lockKey, String value) {
        return Boolean.TRUE.equals(redisTemplate.opsForValue().setIfAbsent(lockKey, value, Duration.ofSeconds(3)));
    }

    public void unLock(String lockKey) {

    }
    @Autowired
    public void setRedisTemplate(StringRedisTemplate redisTemplate) {
        RedisLockUtils.redisTemplate = redisTemplate;
    }
}
