package com.handl.springboot.common.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by handl on 2017/8/22.
 *
 * 创建一个属性bean，用来关联配置文件属性
 *
 */
@Component
@ConfigurationProperties(prefix = "author") //location属性1.4版本后被取消
@PropertySource("classpath:/author.properties") //@ConfigurationProperties的location属性
public class AuthorProperties {

    /**
     * 通过Environment对象也可以设置属性值，要在初始化方法中(构造器中不可以)
     */

    @Autowired
    private Environment environment;

    private String desc; //这个属性没有前缀，通过Environment对象使用

    @PostConstruct //声明为初始化类
    public void init(){
        this.desc = environment.getProperty("desc");
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * 下面是@ConfigurationProperties使用
     */
    private String name;
    private Integer age;


    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
