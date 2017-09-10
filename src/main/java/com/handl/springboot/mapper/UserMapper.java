package com.handl.springboot.mapper;

import com.handl.springboot.pojo.entiry.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

/**
 * Created by handl on 2017/9/10.
 */
public interface UserMapper {

    @Insert("INSERT INTO user (id,name,age,des) VALUES(#{id},#{name},#{age},#{des})")
    @Options(useGeneratedKeys=true, keyProperty="id",keyColumn = "id")
    int save(User user);
}
