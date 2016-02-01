package com.example.dao;

import com.example.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * Created by SunYi on 2016/2/1/0001.
 */
@Repository
//这个注解代表这是一个mybatis的操作数据库的类
public interface UserDao {
    // 根据username获得一个User类
    @Select("select * from user_info where username=#{username} limit 1")
    User getOneUser(String username);

    //插入一个User
    @Insert("insert into user_info (username,password) values(#{username},#{password})")
    boolean setOneUser(User user);

}
