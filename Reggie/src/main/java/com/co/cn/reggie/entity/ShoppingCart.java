package com.co.cn.reggie.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ShoppingCart {
    private Long id;

    private String name;

    private String image;

    private Long userId;

    private Long dishId;

    private Long setmealId;

    private String dishFlavor;

    private Integer number;

    private BigDecimal amount;

    private Date createTime;
}