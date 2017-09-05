package com.handl.springboot.service.impl;

import com.handl.springboot.dao.UserRepository;
import com.handl.springboot.pojo.entiry.User;
import com.handl.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by handl on 2017/9/1.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * 事务：测试数据回滚指定异常回滚
     * @param user
     * @return
     */
    @Override
    @Transactional(rollbackFor = {IllegalArgumentException.class})
    public User saveUserWithRollBack(User user) {
        User u = userRepository.save(user);

        if(u.getName().equals("sel")){
            throw new IllegalArgumentException("sel已存在，数据回滚");
        }
        return u;
    }

    /**
     * 事务：测试数据指定异常不回滚
     * @param user
     * @return
     */
    @Override
    @Transactional(noRollbackFor = {IllegalArgumentException.class})
    public User saveUserWithNoRollBack(User user) {
        User u = userRepository.save(user);

        if(u.getName().equals("ttk")){
            throw new IllegalArgumentException("ttk已存在，但不回滚");
        }
        return u;
    }


    /*****************测试缓存************************/

    @Override
    @CachePut(value = "user",key = "#user.id")
    public User save(User user) {
        User u = userRepository.save(user);
        System.out.println("save方法缓存,id="+u.getId());
        return u;
    }

    @Override
    @CacheEvict(value = "user")
    public void remove(Long id) {
        System.out.println("remove方法缓存,id="+id);
        userRepository.delete(id);
    }

    @Override
    @Cacheable(value = "user",key = "#user.id")
    public User findOne(User user) {
        User u = userRepository.findOne(user.getId());
        System.out.println("findOne方法缓存,id="+u.getId());
        return u;
    }
}
