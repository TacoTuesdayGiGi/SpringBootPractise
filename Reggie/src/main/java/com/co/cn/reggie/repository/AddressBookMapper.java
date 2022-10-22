package com.co.cn.reggie.repository;

import com.co.cn.reggie.entity.AddressBook;

public interface AddressBookMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AddressBook row);

    int insertSelective(AddressBook row);

    AddressBook selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AddressBook row);

    int updateByPrimaryKey(AddressBook row);
}