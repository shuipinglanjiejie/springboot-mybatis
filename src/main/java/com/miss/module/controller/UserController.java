package com.miss.module.controller;

import com.miss.module.entity.User;
import com.miss.module.service.IUserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@RequestMapping("/user")
@EnableAutoConfiguration
public class UserController {

    private Logger log = Logger.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    @RequestMapping("/hello")
    public String home(){
        System.out.println("进入controller");
        log.info("hello");
        return "Hello Spring boot";
    }

    @RequestMapping("/get")
    @ResponseBody
    User getUser(@RequestParam("userName") String userName) {
        log.info("get username:" + userName);
        User user = userService.queryUser(userName);
        log.info(user.toString());
        return user;
    }

    @RequestMapping("/add")
    @ResponseBody
    String add(@RequestParam("userName") String userName, @RequestParam("loginPwd") String loginNum){
        String pwd = createMD5(loginNum);
        System.out.println(userName + ":" + loginNum);
        log.info("add username:" + userName);
        userService.insertUser(userName,pwd);
        return "插入成功";
    }

    @RequestMapping("/getall")
    @ResponseBody
    List<User> getall() {
        log.info("get all users");
        return userService.selectALL();
    }

    private String createMD5(String loginNum){
        MessageDigest md = null;
        try{
            md = MessageDigest.getInstance("MD5");
            md.update(loginNum.getBytes());
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return new BigInteger(1,md.digest()).toString(16);
    }
}
