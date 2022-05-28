package com.scan;

import java.io.File;
import java.lang.annotation.Annotation;
import java.net.URL;
import java.util.ArrayList;

public class MapperScan {
    //通过解析BeanScan来得到文件目录
    Class<BeanScan> beanScanClass;
    public ArrayList<Class>  scan(Class aClass) throws ClassNotFoundException {

        //创建一个ArrayList存放内容
        ArrayList<Class> mapperName = new ArrayList<>();
        BeanScan BeanScan = (com.scan.BeanScan) aClass.getDeclaredAnnotation(BeanScan.class);
        //获取到扫描路径
        String path = BeanScan.value();
        //使用类加载器(类加载器有默认的加载路径)
        ClassLoader classLoader = aClass.getClassLoader();
        Class<?> aClass2 = classLoader.loadClass("Mapper.UserMapper");
        System.out.println(aClass2);
        String replacePath = path.replace(".", "\\");
        URL resource = classLoader.getResource("com ");
        String file = resource.getFile();
        System.out.println(file);
        File file1 = new File("D:\\IdeaVincent\\Spring- Mybatis\\out\\production\\Spring- Mybatis\\Mapper");
        System.out.println(replacePath+"+++++++");
        System.out.println(file1+"=====");
        File[] files1 = file1.listFiles();



        //判断文件下是否有mapper接口
        if(file1.isDirectory()){
            File[] files = file1.listFiles();
            for (File f :files) {
                //字符串截取
                String name1 = file1.getName();
                System.out.println(name1);
                String name = f.getName();
                String pathName = name1+"."+name;
                String substring = pathName.substring(0, pathName.indexOf(".class"));
                System.out.println(substring+"000000");
                ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
                Class<?> aClass1 = contextClassLoader.loadClass(substring);
                mapperName.add(aClass1);
                System.out.println(aClass1);

            }

        }
        return mapperName;

    }
}
