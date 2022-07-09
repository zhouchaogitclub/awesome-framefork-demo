package com.zc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author 周超
 * @since 2022/3/4 22:07
 */
@Builder
@Data
@AllArgsConstructor
public class Person {
    private String name;
    private int age;
}
