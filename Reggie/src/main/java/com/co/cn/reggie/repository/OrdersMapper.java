package com.co.cn.reggie.repository;

import com.co.cn.reggie.entity.Orders;

public interface OrdersMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Orders row);

    int insertSelective(Orders row);

    Orders selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Orders row);

    int updateByPrimaryKey(Orders row);
}