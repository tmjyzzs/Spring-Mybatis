package com;

import Mapper.UserMapper;
import Mapper.orderMapper;
import Mapper.selecetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Bean01 {

    @Autowired
    UserMapper userMapper;

    @Autowired
    orderMapper orderMapper;

    @Autowired
    Mapper.selecetMapper selecetMapper;

    @Autowired
    TextImport textImport;

    public void text(){
        orderMapper.select();
        userMapper.select();
        selecetMapper.select();
        System.out.println("=====");
        textImport.text();
    }
}
