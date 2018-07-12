package com.miss.module.controller;

import com.miss.module.invoke.ResponseModal;
import com.miss.module.redis.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private IRedisService redisService;
    @Autowired
    private JedisConnectionFactory jedisConnectionFactory;

    @RequestMapping("/set")
    public ResponseModal redisSet(@RequestParam("key") String key,@RequestParam("value") String value){
        System.out.println(jedisConnectionFactory.getPassword());
        boolean isOk = redisService.set(key, value);
        return new ResponseModal(isOk ? 200 : 500, isOk, isOk ? "success" : "error" , null);
    }

    @RequestMapping("/get")
    public ResponseModal redisGet(@RequestParam("key") String key){
        String name = redisService.get(key);
        return new ResponseModal(200, true,"success",name);
    }
}
