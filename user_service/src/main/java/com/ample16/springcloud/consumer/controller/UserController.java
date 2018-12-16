package com.ample16.springcloud.consumer.controller;

import com.ample16.springcloud.consumer.dao.UserDao;
import com.ample16.springcloud.consumer.entity.User;
import com.ample16.springcloud.consumer.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @RequestMapping("/save")
    public String save(User user) {
        userService.save(user);
        return "";
    }

    @RequestMapping("/delete")
    public String delete() {
        return "";
    }

    @RequestMapping("/update")
    public String update() {
        return "";
    }

    @RequestMapping("/findAll")
    public List<User> findAll() {
        return null;
    }
}
