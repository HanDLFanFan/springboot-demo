package com.handl.springboot.pojo.websocket;

/**
 * Created by handl on 2017/8/26.
 *
 * 服务器向浏览器发送消息类
 *
 */
public class ServerMessage {

    private String name;
    private Integer age;
    private String mssg;

    public ServerMessage(String name, Integer age, String mssg) {
        this.name = name;
        this.age = age;
        this.mssg = mssg;
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

    public String getMssg() {
        return mssg;
    }

    public void setMssg(String mssg) {
        this.mssg = mssg;
    }
}
