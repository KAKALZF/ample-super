package com.ample16.springcloud.consumer.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
    @RequestMapping("/userInfo")
    public String userInfo() {
        System.out.println("服务被调用...");
        return "用户的基本信息";
    }

    @RequestMapping("/fallBackMethod")
    public String fallBackMethod() {
        System.out.println("容错方法服务被调用...");
        return "用户的基本信息";
    }
}
