package com.co.cn.reggie.repository;

import com.co.cn.reggie.entity.SetmealDish;

public interface SetmealDishMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SetmealDish row);

    int insertSelective(SetmealDish row);

    SetmealDish selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SetmealDish row);

    int updateByPrimaryKey(SetmealDish row);
}