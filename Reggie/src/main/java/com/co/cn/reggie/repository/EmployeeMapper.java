package com.co.cn.reggie.repository;

import com.co.cn.reggie.entity.Employee;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Employee row);

    int insertSelective(Employee row);

    Employee selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Employee row);

    int updateByPrimaryKey(Employee row);
}