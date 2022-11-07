package com.co.cn.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.co.cn.reggie.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper extends BaseMapper<Orders> {

}