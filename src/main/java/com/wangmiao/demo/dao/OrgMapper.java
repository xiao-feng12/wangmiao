package com.wangmiao.demo.dao;

import com.wangmiao.demo.pagemodel.req.OrgRes;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrgMapper {
    OrgRes selectByOrgName(@Param("OrgName") String organzitionname);
}
