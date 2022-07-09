package com.zc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yeyu
 * @since 2021/12/23 10:26 PM
 */
@SpringBootApplication
@RestController
public class MongoApplication {
    public static void main(String[] args) {
        SpringApplication.run(MongoApplication.class, args);
    }

    @GetMapping("getUserInfo2")
    public ResponseEntity<Object> getUserInfo2() {
        Map<String, Object> map = new HashMap<>();
        try {
            map.put("id", "1001");
            map.put("name", "张三");
            map.put("age", "33");
            map.put("address", "湖北省神农架野人洞");
            // 模拟异常
            int i = 1 / 0;
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("异常:" + ex.getMessage());
        }
        return ResponseEntity.ok().body(map);
    }
}
