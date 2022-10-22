package com.co.cn.reggie.entity;

import lombok.Data;

import java.util.Date;

@Data
public class AddressBook {
    private Long id;

    private Long userId;

    private String consignee;

    private Byte sex;

    private String phone;

    private String provinceCode;

    private String provinceName;

    private String cityCode;

    private String cityName;

    private String districtCode;

    private String districtName;

    private String detail;

    private String label;

    private Boolean isDefault;

    private Date createTime;

    private Date updateTime;

    private Long createUser;

    private Long updateUser;

    private Integer isDeleted;
}