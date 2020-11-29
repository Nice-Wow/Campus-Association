package com.cb.module.borrow.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cb.module.borrow.domain.borrow;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface borrowRepository extends BaseMapper<borrow> {
    int addBorrow(borrow borrow);
    int deleteBorrow(@Param("id") long id, @Param("itemsId") long itemsId);
    borrow selectBorrow(@Param("id") long id, @Param("itemsId") long itemsId);
    List<borrow> selectMyBorrow(long id);
}
