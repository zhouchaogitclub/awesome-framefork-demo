package org.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yeyu
 * @since 2021/8/11 6:31 下午
 */
@RestController
public class HelloController {
    @GetMapping("hello")
    public String hello() {
        return "hello";
    }
}
