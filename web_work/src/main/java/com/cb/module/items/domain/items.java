package com.cb.module.items.domain;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("items")
public class items {

    private static final long serialVersionUID = 1L;

    @TableId
    private long itemsId;

    private String itemsName;

    private long id;

    private String numbers;

    private String nowNumbers;

    private String detail;

    private String photoUrl;

    private String community;

    private String location;

    private String tag;


}
