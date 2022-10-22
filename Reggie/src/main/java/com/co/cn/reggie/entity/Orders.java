package com.co.cn.reggie.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Orders {
    private Long id;

    private String number;

    private Integer status;

    private Long userId;

    private Long addressBookId;

    private Date orderTime;

    private Date checkoutTime;

    private Integer payMethod;

    private BigDecimal amount;

    private String remark;

    private String phone;

    private String address;

    private String userName;

    private String consignee;
}