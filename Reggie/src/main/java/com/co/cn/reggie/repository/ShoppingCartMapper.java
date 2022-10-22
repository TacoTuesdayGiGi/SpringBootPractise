package com.co.cn.reggie.repository;

import com.co.cn.reggie.entity.ShoppingCart;

public interface ShoppingCartMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ShoppingCart row);

    int insertSelective(ShoppingCart row);

    ShoppingCart selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ShoppingCart row);

    int updateByPrimaryKey(ShoppingCart row);
}