package com.co.cn.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.co.cn.reggie.entity.AddressBook;
import com.co.cn.reggie.mapper.AddressBookMapper;
import com.co.cn.reggie.service.AddressBookService;
import org.springframework.stereotype.Service;

@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook> implements AddressBookService {

}
