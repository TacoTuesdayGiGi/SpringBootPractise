package com.co.cn.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.co.cn.reggie.entity.OrderDetail;
import com.co.cn.reggie.mapper.OrderDetailMapper;
import com.co.cn.reggie.service.OrderDetailService;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {
}
