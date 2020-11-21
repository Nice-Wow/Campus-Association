package com.cb.module.borrow.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cb.module.borrow.domain.borrow;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface borrowRepository extends BaseMapper<borrow> {
    int deleteBorrow(long id,long itemsId);
    borrow selectBorrow(long id,long itemsId);
    List<borrow> selectMyBorrow(long id);
}
