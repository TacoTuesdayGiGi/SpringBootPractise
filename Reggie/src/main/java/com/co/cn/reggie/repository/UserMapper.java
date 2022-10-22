package com.co.cn.reggie.repository;

import com.co.cn.reggie.entity.User;

public interface UserMapper {
    int insert(User row);

    int insertSelective(User row);
}