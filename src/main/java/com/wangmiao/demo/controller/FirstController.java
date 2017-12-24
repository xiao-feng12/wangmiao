package com.wangmiao.demo.controller;

import com.wangmiao.demo.entity.User;
import com.wangmiao.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FirstController {

    @Value("${userName}")
    private String userName;

    @Value("${bookTitle}")
    private String bookTitle;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/")
    public String index(ModelMap map) {
        // 加入一个属性，用来在模板中读取
        map.addAttribute("name", userName);
        map.addAttribute("bookTitle", bookTitle);
        // return模板文件的名称，对应src/main/resources/templates/welcome.html
        User user = userRepository.getOne(1L);
        map.addAttribute("userId",user.getuId());
        map.addAttribute("userName",user.getName());
        return "welcome";
    }

    @RequestMapping("/thymeleaf")
    public String thymeleaf(ModelMap map) {
        User user = userRepository.getOne(1L);
        map.addAttribute("name",user.getName());
        return "hello";
    }

}
