package com.miss.module.mapper;

import com.miss.module.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    int insertUser(@Param("username")String username, @Param("password")String password);

    User findByName(String username);

    List<User> selectALL();

    void deleteUser(String username);
}
