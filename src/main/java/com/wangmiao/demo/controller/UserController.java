package com.wangmiao.demo.controller;


import com.wangmiao.demo.entity.User;
import com.wangmiao.demo.pagemodel.req.LoginUserReq;
import com.wangmiao.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    //RequestMethod.POST请求方法
    @RequestMapping(value = "login",method = RequestMethod.POST)
    //headers = "content-type=application/json就是说明他是用json这个格式来传递
    public String login(@ModelAttribute("form") LoginUserReq loginUserReq){
        User user = null;
        if (loginUserReq.getName() != null && loginUserReq.getKeyword() != null){
             user = userRepository.findByNameAndKeyword(loginUserReq.getName(), loginUserReq.getKeyword());
        }
        System.out.println("name = " + loginUserReq.getName());
        System.out.println("keyword = " + loginUserReq.getKeyword());
        if (user == null){
            return "loginfail";
        } else {
            return "loginsuccess";
        }
    }





}
