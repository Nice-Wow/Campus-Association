package com.cb.module.items.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cb.module.items.domain.items;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface itemsRepository extends BaseMapper<items> {

    List<items> listAllproduct();

    List<items> listProductByUserId(long id);

    int updateItemByItemId(items items);

    List<items> listProductByItemsName(String itemsName);

    int deleteItemByItemId(long itemsId);

    items selectItemsById(long itemsId);
}
