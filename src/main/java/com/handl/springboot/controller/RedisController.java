package com.handl.springboot.controller;

import com.handl.springboot.dao.redis.RedisDao;
import com.handl.springboot.pojo.entiry.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by handl on 2017/9/1.
 */
@RestController
public class RedisController {

    @Autowired
    private RedisDao redisDao;

    @RequestMapping("stringSet")
    public String stringSet(User user){
        redisDao.stringSet(user);
        return "ok";
    }
    @RequestMapping("redisSet")
    public String redisSet(User user){
        redisDao.redisSet(user);
        return "ok";
    }
    @RequestMapping("valStrSet")
    public String valStrSet(User user){
        redisDao.valStrSet(user);
        return "ok";
    }
    @RequestMapping("valObjSet")
    public String valObjSet(User user){
        redisDao.valObjSet(user);
        return "ok";
    }

    @RequestMapping("stringGet")
    public String stringGet(User user){
        return redisDao.stringGet(user);
    }
    @RequestMapping("redisGet")
    public User redisGet(User user){
        return redisDao.redisGet(user);
    }
    @RequestMapping("valStrGet")
    public String valStrGet(User user){
        return redisDao.valStrGet(user);
    }
    @RequestMapping("valObjGet")
    public User valObjGet(User user){
        return redisDao.valObjGet(user);
    }
}
