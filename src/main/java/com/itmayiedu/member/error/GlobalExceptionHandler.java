package com.itmayiedu.member.error;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice(basePackages = "com.itmayiedu.member.controller")
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(RuntimeException.class)
    public Map<String, Object> errorResult() {
        Map<String, Object> map = new HashMap<>();
        map.put("errorCode", 500);
        map.put("errorMessage", "系统错误");
        return map;
    }
}
