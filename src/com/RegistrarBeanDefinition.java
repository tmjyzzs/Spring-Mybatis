package com;

import Mapper.UserMapper;
import Mapper.orderMapper;
import com.scan.MapperScan;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.List;

public class RegistrarBeanDefinition implements ImportBeanDefinitionRegistrar {
    //ImportBeanDefinition是用来注册BeanDefinition



    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        //使用BeanDefinitionRegistrar用来注册BeanDefinition
        //通过扫手写serMapper接口的来实现自动注册
        //手写一个ComponentScan
        MapperScan mapperScan = new MapperScan();
        ArrayList<Class> classes = null;
        try {
           classes = mapperScan.scan(MapperConfig.class);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //进行注册
        for (Class cl:classes) {
            System.out.println("==================================== ");
            AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
            beanDefinition.setBeanClass(UserMapperFactoryBean.class);
            beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(cl);
            registry.registerBeanDefinition(cl.getName(),beanDefinition);
        }

    }
}
