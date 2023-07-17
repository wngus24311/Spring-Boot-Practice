package com.fastcampus.ch1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@SpringBootApplication
public class Ch1Application {

    public static void main(String[] args) {
        System.out.println("Hello");
        SpringApplication.run(Ch1Application.class, args);
    }

    @GetMapping("/")
    public String hello() {
        return "index";
    }

}
