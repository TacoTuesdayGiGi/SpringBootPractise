package com.co.cn.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.co.cn.reggie.entity.ShoppingCart;
import com.co.cn.reggie.mapper.ShoppingCartMapper;
import com.co.cn.reggie.service.ShoppingCartService;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart> implements ShoppingCartService {

}
