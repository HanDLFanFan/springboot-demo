package com.handl.springboot.dao.redis;

import com.handl.springboot.pojo.entiry.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by handl on 2017/9/1.
 */
@Repository
public class RedisDao {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;

    @Resource(name = "stringRedisTemplate")
    private ValueOperations<String,String> valOpsStr;

    @Resource(name = "redisTemplate")
    private ValueOperations<Object,Object> valOpsObj;

    public void stringSet(User user){
        stringRedisTemplate.opsForValue().set("stringRedisTemplate:"+user.getName(),user.getDes());
    }

    public void redisSet(User user){
        redisTemplate.opsForValue().set("redisTemplate:"+user.getId(),user);
    }

    public void valStrSet(User user){
        valOpsStr.set("valOpsStr:"+user.getName(),user.getDes());
    }

    public void valObjSet(User user){
        valOpsObj.set("valOpsObj:"+user.getId(),user);
    }


    public String stringGet(User user){
       return stringRedisTemplate.opsForValue().get("stringRedisTemplate:"+user.getName());
    }

    public User redisGet(User user){
        return (User) redisTemplate.opsForValue().get("redisTemplate:"+user.getId());
    }

    public String valStrGet(User user){
       return valOpsStr.get("valOpsStr:"+user.getName());
    }

    public User valObjGet(User user){
        return (User) valOpsObj.get("valOpsObj:"+user.getId());
    }

}
