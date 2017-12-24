package com.wangmiao.demo.dao;

import com.wangmiao.demo.pagemodel.res.UserRes;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    /**
     *
     * @param userId 用户编号
     * @return 用户Res
     */
    UserRes selectByUserId(@Param("userId") Long userId);
}
