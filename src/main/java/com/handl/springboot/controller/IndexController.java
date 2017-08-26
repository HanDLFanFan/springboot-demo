package com.handl.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by handl on 2017/8/24.
 */
@RestController
public class IndexController {

    //通过@Value直接使用application.properties文件里的属性
    @Value("${name}")
    private String name;

    @Value("${desc}")
    private String desc;

    @RequestMapping("proper")
    public String proper(){
        return "I'm "+name+",and "+desc+"。Hello Spring Boot";
    }
}
