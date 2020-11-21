package com.cb.module.borrow.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cb.module.borrow.domain.borrow;
import com.cb.module.common.entity.AjaxResult;

import java.util.List;

public interface borrowService extends IService<borrow> {
    public AjaxResult addBorrow(borrow borrow);
    public int deleteBorrow(long id,long itemsId);
    public borrow selectBorrow(long id,long itemsId);
    public List<borrow> selectMyBorrow(long id);
}
