package com.co.cn.reggie.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class SetmealDish {
    private Long id;

    private String setmealId;

    private String dishId;

    private String name;

    private BigDecimal price;

    private Integer copies;

    private Integer sort;

    private Date createTime;

    private Date updateTime;

    private Long createUser;

    private Long updateUser;

    private Integer isDeleted;
}