package com.fastcampus.ch1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 1. 원격 프로그램으로 등록
@RestController
public class HelloController { // 원격 프로그램
    // 2. URL 과 Method를 연결
    @RequestMapping("/hello")
    public String main() {
        System.out.println("Hello");
        return "Hello";
    }
}
