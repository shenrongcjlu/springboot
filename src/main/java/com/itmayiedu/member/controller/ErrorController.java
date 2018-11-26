package com.itmayiedu.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorController {

    @RequestMapping("/errorIndex")
    public String errorIndex(int i) {
        return "the result is " + 1 / i;
    }

}
