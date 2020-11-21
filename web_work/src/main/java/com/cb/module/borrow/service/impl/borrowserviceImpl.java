package com.cb.module.borrow.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cb.module.borrow.dao.borrowRepository;
import com.cb.module.borrow.domain.borrow;
import com.cb.module.borrow.service.borrowService;
import com.cb.module.common.entity.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class borrowserviceImpl extends ServiceImpl<borrowRepository, borrow> implements borrowService {

    @Autowired
    private borrowRepository borrowRepository;

    @Override
    public AjaxResult addBorrow(borrow borrow) {
        return this.baseMapper.insert(borrow) == 0 ? AjaxResult.error("租借失败") : AjaxResult.success("租借成功");
    }

    @Override
    public int deleteBorrow(long id, long itemsId) {
        return borrowRepository.deleteBorrow(id,itemsId);
    }

    @Override
    public borrow selectBorrow(long id, long itemsId) {
        return borrowRepository.selectBorrow(id,itemsId);
    }

    @Override
    public List<borrow> selectMyBorrow(long id) {
        return borrowRepository.selectMyBorrow(id);
    }
}
