package com.miss.module.service.impl;

import com.miss.module.entity.User;
import com.miss.module.mapper.UserMapper;
import com.miss.module.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service()
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int testInterFace() {
        return 0;
    }

    @Override
    public User queryUser(String username) {
        return userMapper.findByName(username);
    }

    @Override
    public int insertUser(String username,String password) {
        return userMapper.insertUser(username,password);
    }

    @Override
    public List<User> selectALL(){
        return userMapper.selectALL();
    }

    @Override
    public void deleteUser(String username){
        userMapper.deleteUser(username);
    }
}
