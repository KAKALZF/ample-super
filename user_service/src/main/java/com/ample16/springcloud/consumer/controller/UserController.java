package com.ample16.springcloud.consumer.controller;

import com.ample16.springcloud.consumer.dao.UserDao;
import com.ample16.springcloud.consumer.entity.User;
import com.ample16.springcloud.consumer.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/saveOrUpdate")
    @ApiOperation(value = "用户保存或更新")
    public String save(@RequestBody User user) {
        userService.saveOrUpdate(user);
        return "success";
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "用户权限删除")
    public String delete(Long id) {
        userService.delete(id);
        return "success";
    }


    @GetMapping("/findAll")
    @ApiOperation("用户列表")
    public List<User> findAll() {
        return userService.findAll();
    }
}
