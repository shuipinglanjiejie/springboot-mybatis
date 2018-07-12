package com.miss.module.controller;

import com.miss.module.kafka.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Miss
 * @Description:
 * @Date: 2018/5/22 15:13
 */
@RestController
@RequestMapping("/kafka")
public class SendController {

    @Autowired
    private Producer producer;

    @RequestMapping(value = "/send")
    public String send() {
        producer.send();
        return "{\"code\":0}";
    }
}
