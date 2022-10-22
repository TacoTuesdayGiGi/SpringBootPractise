package com.co.cn.reggie.repository;

import com.co.cn.reggie.entity.Category;

public interface CategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Category row);

    int insertSelective(Category row);

    Category selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Category row);

    int updateByPrimaryKey(Category row);
}