package com.handl.springboot.pojo.es;

import java.io.Serializable;

/**
 * Created by handl on 2017/9/9.
 */
public class Tutorial implements Serializable{
    private Long id;
    private String name;//教程名称

    public Tutorial() {
    }

    public Tutorial(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
