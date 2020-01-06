package com.example.springbootdemo3.mapper;

import com.example.springbootdemo3.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {


    // 保存对象，获取数据库自增id,keyColumn:数据库自增主键名
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    @Insert("insert into users(name,phone,create_time,age) values (#{name},#{phone},#{createTime},#{age})")
    Integer insert(User user);


    @Select("select * from users")
    @Results({ @Result(column = "create_time",property = "createTime")})
    List<User> getAllUsers();

    @Select("select * from users where id=#{id}")
    @Results({ @Result(column = "create_time",property = "createTime")})
    User findById(Integer id);

    @Update("update users set name=#{name} where id=#{id}")
    void update(User user);

    @Delete("delete from users where id=#{userId}")
    void delete(Integer userId);
}
