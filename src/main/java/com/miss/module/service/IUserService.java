package com.miss.module.service;

import com.miss.module.entity.User;

import java.util.List;

public interface IUserService {

    public int testInterFace();

    public User queryUser(String username);

    public int insertUser(String username,String password);

    public List<User> selectALL();

    public void deleteUser(String username);
}
