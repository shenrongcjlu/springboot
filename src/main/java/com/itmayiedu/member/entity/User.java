package com.itmayiedu.member.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Getter
@Setter
@Log4j
public class User {
    private String name;
    private Integer age;

    public static void main(String[] args) {
        User user = new User();
    }

}

