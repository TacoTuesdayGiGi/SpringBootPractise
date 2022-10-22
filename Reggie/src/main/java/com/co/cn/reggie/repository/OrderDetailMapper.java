package com.co.cn.reggie.repository;

import com.co.cn.reggie.entity.OrderDetail;

public interface OrderDetailMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OrderDetail row);

    int insertSelective(OrderDetail row);

    OrderDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrderDetail row);

    int updateByPrimaryKey(OrderDetail row);
}