package com.wangmiao.demo.controller;

import com.wangmiao.demo.pagemodel.req.FillInfoReq;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class InformationController {

    @RequestMapping(value = "fillOne",method = RequestMethod.POST)
    public String fillOne(@ModelAttribute("form") FillInfoReq fillInfoReq ) {
        return "student/currentJob";
    }
}
