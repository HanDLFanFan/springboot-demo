package com.handl.springboot.service;

import com.handl.springboot.pojo.entiry.User;

/**
 * Created by handl on 2017/9/1.
 */
public interface UserService {

    /************测试事务*************/
    User saveUserWithRollBack(User user);
    User saveUserWithNoRollBack(User user);


    /************测试缓存*************/
    User save(User user);
    void remove(Long id);
    User findOne(User user);



}
