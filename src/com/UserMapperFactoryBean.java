package com;

import Mapper.UserMapper;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class UserMapperFactoryBean implements FactoryBean {

    Class aClass;

    public UserMapperFactoryBean(Class aClass) {
        this.aClass = aClass;
    }

    @Override
    public Object getObject() throws Exception {
       Object object =  Proxy.newProxyInstance(UserMapperFactoryBean.class.getClassLoader(), new Class[]{aClass},
                new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("动态代理调用成功");
                System.out.println(method.getName());
                return 1;
            }
        });
        return object;
    }

    @Override
    public Class<?> getObjectType() {
        return aClass;
    }
}
