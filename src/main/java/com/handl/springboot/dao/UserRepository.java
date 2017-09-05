package com.handl.springboot.dao;

import com.handl.springboot.pojo.entiry.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * Created by handl on 2017/8/30.
 */
@RepositoryRestResource(path = "users")
public interface UserRepository extends JpaRepository<User,Long>{
    //使用方法名查询
    @RestResource(path = "des")
    List<User> findByDes(@Param("des") String des);
    //使用方法名查询
    User findByNameAndDes(String name,String des);
    //使用@NamedQuery查询，实体bean定义的@NamedQuery
    User withNameAndDesNamedQuery(String name,String des);

    @Query("select u from User u where u.name= :name and des= :des")
    User withNameAndDesQuery(@Param("name")String name,
                             @Param("des")String des);

}
