package com.co.cn.reggie.repository;

import com.co.cn.reggie.entity.DishFlavor;

public interface DishFlavorMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DishFlavor row);

    int insertSelective(DishFlavor row);

    DishFlavor selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DishFlavor row);

    int updateByPrimaryKey(DishFlavor row);
}