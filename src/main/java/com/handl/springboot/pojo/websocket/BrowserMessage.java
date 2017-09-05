package com.handl.springboot.pojo.websocket;

/**
 * Created by handl on 2017/8/26.
 *
 * 浏览器向服务端发送消息的接受类
 *
 */
public class BrowserMessage {

    private String name;
    private Integer age;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
}
