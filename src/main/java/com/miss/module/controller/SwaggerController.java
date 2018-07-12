package com.miss.module.controller;

import com.miss.module.entity.User;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zl on 2015/8/27.
 */
@RestController
@RequestMapping(value="/swagger")
public class SwaggerController {
    /**
     * http://localhost:8090/swagger/index.html
     * @return
     */
    @ApiOperation(value="Get all users",notes="requires noting")
    @RequestMapping(method=RequestMethod.GET)
    public List<User> getUsers(){
        List<User> list=new ArrayList<User>();

        User user1=new User();
        user1.setUsername("hello");
        list.add(user1);

        User user2=new User();
        user2.setUsername("world");
        list.add(user2);
        return list;
    }

    @ApiOperation(value="Get user with id",notes="requires the id of user")
    @RequestMapping(value="/{username}",method=RequestMethod.GET)
    public User getUserById(@PathVariable String username){
        User user=new User();
        user.setUsername(username);
        return user;
    }
}