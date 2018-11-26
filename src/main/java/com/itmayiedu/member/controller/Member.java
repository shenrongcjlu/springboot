package com.itmayiedu.member.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class Member {

    @RequestMapping("/meberIndex")
    public String memberContrller() {
        return "hello springboot2.0";
    }


}
