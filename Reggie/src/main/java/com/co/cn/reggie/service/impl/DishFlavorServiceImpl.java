package com.co.cn.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.co.cn.reggie.entity.DishFlavor;
import com.co.cn.reggie.mapper.DishFlavorMapper;
import com.co.cn.reggie.service.DishFlavorService;
import org.springframework.stereotype.Service;

@Service
public class DishFlavorServiceImpl extends ServiceImpl<DishFlavorMapper, DishFlavor> implements DishFlavorService {
}
