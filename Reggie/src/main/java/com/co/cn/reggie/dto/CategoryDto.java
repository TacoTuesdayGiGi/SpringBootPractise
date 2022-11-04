package com.co.cn.reggie.dto;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.Date;

/**
 * 分类
 */
@Data
public class CategoryDto {

    private String id;

    private Integer type;

    private String name;

    private Integer sort;

    private String createTime;

    private String updateTime;

    private String createUser;

    private String updateUser;
}
