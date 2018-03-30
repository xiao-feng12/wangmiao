package com.wangmiao.demo.dao;

import com.wangmiao.demo.pojo.Pile;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PileMapper {

    List<Pile> selectPilesByLimit(@Param("beginRow") int beginRow,
                                  @Param("qty") int qty);

}
