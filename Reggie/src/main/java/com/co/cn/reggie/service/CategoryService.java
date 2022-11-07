package com.co.cn.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.co.cn.reggie.entity.Category;

public interface CategoryService extends IService<Category> {

    void remove(String id);

}
