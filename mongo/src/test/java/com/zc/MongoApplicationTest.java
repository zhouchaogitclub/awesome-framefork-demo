package com.zc;

import com.mongodb.client.MongoDatabase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yeyu
 * @since 2021/12/23 10:26 PM
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MongoApplicationTest {
    @Resource
    private MongoTemplate mongoTemplate;

    @Test
    public void testMongo() {
        MongoDatabase db = mongoTemplate.getDb();
        Map<String, String> objectToSave = new HashMap<>();
        objectToSave.put("name", "zhouchao");
        objectToSave.put("age", "100");
        Map<String, String> insert = mongoTemplate.insert(objectToSave);
        System.out.println(insert);
    }
}