package com.co.cn.reggie.repository;

import com.co.cn.reggie.entity.Dish;

public interface DishMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Dish row);

    int insertSelective(Dish row);

    Dish selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Dish row);

    int updateByPrimaryKey(Dish row);
}