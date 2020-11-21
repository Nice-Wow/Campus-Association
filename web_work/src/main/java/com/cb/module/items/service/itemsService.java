package com.cb.module.items.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cb.module.common.entity.AjaxResult;
import com.cb.module.items.domain.items;

import java.util.List;

public interface itemsService extends IService<items> {

    public AjaxResult addItems(items item);
    public List<items> listAllproduct();
    public List<items> listProductByUserId(long id);
    public int updateItemByItemId(items items);
    public List<items> listProductByItemsName(String itemsName);
    public int deleteItemByItemId(long itemsId);
    public items selectItemsById(long itemsId);
}
