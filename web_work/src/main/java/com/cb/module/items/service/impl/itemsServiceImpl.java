package com.cb.module.items.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cb.module.common.entity.AjaxResult;
import com.cb.module.items.dao.itemsRepository;
import com.cb.module.items.domain.items;
import com.cb.module.items.service.itemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class itemsServiceImpl extends ServiceImpl<itemsRepository, items> implements itemsService {

    @Autowired
    private itemsRepository itemsRepository;

    @Override
    public AjaxResult addItems(items item){
        item.setNowNumbers(item.getNumbers());
        item.setTag("1");
        return this.baseMapper.insert(item) == 0 ? AjaxResult.error("注册失败") : AjaxResult.success("注册成功");
    }

    @Override
    public List<items> listAllproduct() {
        return itemsRepository.listAllproduct();
    }

    @Override
    public List<items> listProductByUserId(long id) {
        return itemsRepository.listProductByUserId(id);
    }

    @Override
    public int updateItemByItemId(items items) {
        return itemsRepository.updateItemByItemId(items);
    }

    @Override
    public List<items> listProductByItemsName(String itemsName) {
        return itemsRepository.listProductByItemsName(itemsName);
    }

    @Override
    public int deleteItemByItemId(long itemsId) {
        return itemsRepository.deleteItemByItemId(itemsId);
    }

    @Override
    public items selectItemsById(long itemsId) {
        return itemsRepository.selectItemsById(itemsId);
    }
}
