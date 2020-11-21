package com.cb.module.borrow.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("borrow")
public class borrow {

    private static final long serialVersionUID = 1L;

    private long id;

    private long itemsId;

    private String borrowNumbers;

    private String itemsName;
}
