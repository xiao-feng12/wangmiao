package com.wangmiao.demo.controller;

import com.wangmiao.demo.entity.Organization;
import com.wangmiao.demo.pagemodel.req.SelectOrgReq;
import com.wangmiao.demo.repository.OrgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OrgController {

    //要保存到数据库中所要使用的
    @Autowired
    private OrgRepository orgRepository;
    /**
     * select方法
     * RequestMapping
     */
    @RequestMapping(value = "select",method = RequestMethod.POST)
    public String select(@ModelAttribute("form") SelectOrgReq selectOrgReq) {

        System.out.println( "org:\n"+ selectOrgReq.getOrganization());

        //创建 new 对象
        Organization organization = new Organization();

        //将 html 的 value  save 到 对象中
        organization.setName(selectOrgReq.getOrganization());

        //将对象 save 到数据库中
        orgRepository.save(organization);

        return "student/information";

    }
}
