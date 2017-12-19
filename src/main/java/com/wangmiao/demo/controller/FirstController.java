package com.wangmiao.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

    @RequestMapping("/")
    String index(){
        return "Hello wangmiao";
    }
}
