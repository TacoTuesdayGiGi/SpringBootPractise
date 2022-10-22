package com.co.cn.reggie.repository;

import com.co.cn.reggie.entity.Setmeal;

public interface SetmealMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Setmeal row);

    int insertSelective(Setmeal row);

    Setmeal selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Setmeal row);

    int updateByPrimaryKey(Setmeal row);
}