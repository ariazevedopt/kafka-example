package com.example.demo1.controller;


import com.example.demo1.service.Producer;
import com.kafka.schema.UserExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
public class Controller {

    static final Logger logger = LoggerFactory.getLogger(Controller.class);

    @Autowired
    Producer producer;

    @PostMapping("/addUser")
    public String avroMessageUser(@RequestBody UserExample user) {

        producer.sendExampleMessage(user);

        return "Success";
    }

    @ResponseBody
    @GetMapping("/getGroup")
    public String requestGroup(@RequestParam(value = "group") String group) throws ExecutionException, InterruptedException {

        return producer.requestReplyGroup(group);
    }

}