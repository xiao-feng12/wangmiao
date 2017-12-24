package com.wangmiao.demo.controller;

import com.wangmiao.demo.dao.UserMapper;
import com.wangmiao.demo.entity.User;
import com.wangmiao.demo.pagemodel.res.UserRes;
import com.wangmiao.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FirstController {

    @Value("${names}")
    private String names;

    @Value("${bookTitle}")
    private String bookTitle;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/")
    public String thymeleaf(ModelMap map) {
        // 加入一个属性，用来在模板中读取
        map.addAttribute("names", names);
        map.addAttribute("bookTitle", bookTitle);
        User user = userRepository.getOne(1L);
        map.addAttribute("name",user.getName());
        UserRes userRes = userMapper.selectByUserId(1L);
        map.addAttribute("mapperName",userRes.getName());
        return "hello";
    }

}
