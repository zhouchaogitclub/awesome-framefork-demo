package com.zc;

import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.config.Config;

/**
 * @author yeyu
 * @since 2021/6/9 6:59 下午
 */
public class SingleRedissonDemo {
    public static void main(String[] args) {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://localhost:6379");
        config.setCodec(new JsonJacksonCodec());
        RedissonClient redisson = Redisson.create(config);
        RBucket<String> name = redisson.getBucket("name");
        System.out.println(name.trySet("11"));
    }

    public static class User{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
