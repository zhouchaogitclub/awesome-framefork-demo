package com.zc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author yeyu
 * @since 2022/6/10 13:52
 */
@SpringBootApplication
@RestController
public class DistributedLockApplication {
    public static void main(String[] args) {
        SpringApplication.run(DistributedLockApplication.class);
    }
    @Resource
    private HttpServletRequest request;
    @GetMapping
    public String index() {
        System.out.println(request.getRemoteAddr());
        System.out.println(request.getRemoteHost());
        System.out.println(request.getHeader("X-Forwarded-For"));
        return "hello world";
    }
}
