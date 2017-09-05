package com.handl.springboot.pojo.entiry;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by handl on 2017/8/30.
 */
@Entity
@Table(name = "user")
@NamedQuery(name = "User.withNameAndDesNamedQuery",
        query = "select u from User u where u.name=?1 and des=?2")
public class User implements Serializable {

    @Id
    private Long id;

    private String name;
    private Integer age;
    private String des;

    //redis ---- jack2json序列化需要一个空构造
    public User() {
    }

    public User(Long id, String name, Integer age, String des) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.des = des;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
