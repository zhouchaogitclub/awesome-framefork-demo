package com.zc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author yeyu
 * @since 2021/8/14 9:22 下午
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisApplicationTest {
    @Resource
    private StringRedisTemplate template;

    @Test
    public void a() {

    }
}