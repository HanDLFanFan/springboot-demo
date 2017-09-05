package com.handl.springboot.controller;

import com.handl.springboot.dao.UserRepository;
import com.handl.springboot.pojo.entiry.User;
import com.handl.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by handl on 2017/8/30.
 */
@RestController
@RequestMapping("jpa")
public class JpaDataController {

    //注入repository
    @Autowired
    private UserRepository userRepository;

    /**
     * 保存
     * @param name
     * @param age
     * @param des
     * @return
     */
    @RequestMapping("save")
    public User save(Long id,String name,Integer age,String des){
        System.out.println("进来没");
        User user = userRepository.save(new User(id,name,age,des));
        return user;
    }

    @RequestMapping("/{des}")
    public List<User> findByDes(@PathVariable String des){
        return userRepository.findByDes(des);
    }

    @RequestMapping("namedes")
    public User findByNameAndDes(String name,String des){
        return userRepository.findByNameAndDes(name,des);
    }

    @RequestMapping("namedes2")
    public User withNameAndDesNamedQuer(String name,String des){
        return userRepository.withNameAndDesNamedQuery(name,des);
    }

    @RequestMapping("namedes3")
    public User withNameAndDesQuery(String name,String des){
        return userRepository.withNameAndDesQuery(name,des);
    }

    @RequestMapping("sort")
    public List<User> sort(){
        return userRepository.findAll(new Sort(Sort.Direction.ASC,"age"));
    }

    @RequestMapping("page")
    public Page<User> page(){
        return userRepository.findAll(new PageRequest(1,2));
    }



    /**********************事务测试************************/

    @Autowired
    private UserService userService;

    /**
     * 回滚
     * @param user
     * @return
     */
    @RequestMapping("rollback")
    public User rollBack(User user){

        return userService.saveUserWithRollBack(user);
    }

    /**
     * 不回滚
     * @param user
     * @return
     */
    @RequestMapping("norollback")
    public User noRollBack(User user){

        return userService.saveUserWithNoRollBack(user);
    }


    /*****************测试缓存***********************/
    @RequestMapping("cachesave")
    public User save(User user){
        return userService.save(user);
    }

    @RequestMapping("remove")
    public String remove(Long id){
        userService.remove(id);
        return "ok";
    }

    @RequestMapping("findOne")
    public User findOne(User user){
        return userService.findOne(user);
    }
}
