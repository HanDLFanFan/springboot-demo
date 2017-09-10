package com.handl.springboot.mapper;

import com.handl.springboot.SpringbootDemoApplicationTests;
import com.handl.springboot.pojo.entiry.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by handl on 2017/9/10.
 */
public class UserMapperTest extends SpringbootDemoApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void saveTest(){
        User user = new User();
        user.setId((long) 10);
        user.setName("斩妖泣血");
        user.setAge(10);
        user.setDes("dt");
        int i = userMapper.save(user);
        System.out.println("保存结果="+i);
    }
}
