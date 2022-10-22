package com.co.cn.reggie.entity;

import lombok.Data;

import java.util.Date;

@Data
public class DishFlavor {
    private Long id;

    private Long dishId;

    private String name;

    private String value;

    private Date createTime;

    private Date updateTime;

    private Long createUser;

    private Long updateUser;

    private Integer isDeleted;
}