package com.wangmiao.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import com.wangmiao.demo.pagemodel.req.UserRes;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    /**
     * @param Id 用户Id
     *
     * @return 用户res
     */
    UserRes selectByUserId(@Param("userId") Long Id);

}
