package com.handl.springboot.controller;

import com.handl.springboot.common.properties.AuthorProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by handl on 2017/8/22.
 */
@RestController
public class AuthorPropertiesController {

    //通过属性Bean的方式使用
   @Autowired
    private AuthorProperties authorProperties;

    //直接通过Environment对象使用
    @Autowired
    private Environment environment;


    //直接通过Environment对象使用(也要配合@PropertySource注解)
    @RequestMapping("author2")
    public String author2(){
        return "author2 this is test author.properties,my name is "+
                environment.getProperty("author.name")+" and my age is "+
                environment.getProperty("author.age")+
                ",i want "+ environment.getProperty("desc");
    }

    //通过属性Bean的方式使用
    @RequestMapping("author")
    public String author(){
        return "author this is test author.properties,my name is "+
                authorProperties.getName()+" and my age is "+
                authorProperties.getAge()+
                "i want "+authorProperties.getDesc();
    }

}
