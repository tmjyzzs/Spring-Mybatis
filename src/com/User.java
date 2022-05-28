package com;

import Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class User {

    @Autowired
    UserMapper uw;


    public void selectId(){
        System.out.println("uw注入成功");
        uw.select();
    }

}
