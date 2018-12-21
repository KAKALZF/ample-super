package com.ample16.springcloud.consumer.controller;

import com.ample16.springcloud.consumer.common.Response;
import com.ample16.springcloud.consumer.common.req.RegisterReq;
import com.ample16.springcloud.consumer.dao.UserDao;
import com.ample16.springcloud.consumer.entity.User;
import com.ample16.springcloud.consumer.service.UserService;
import com.ample16.springcloud.consumer.service.serviceimpl.RequiredPermission;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /*注册账号/密码:root/admin*/
    @PostMapping("/register")
    public Response register(@RequestBody RegisterReq registerReq) {
        User user = new User()
                .setName(registerReq.getName())
                .setPassword(registerReq.getPassword());
        userService.register(user);
        return Response.successResposne();
    }


    @PostMapping("/saveOrUpdate")
    @ApiOperation(value = "用户保存或更新")
    @RequiredPermission(value = "saveOrUpdate", des = "用户保存或更新")
    @RequiresRoles("admin")
    @RequiresPermissions("create")
    public Response saveOrUpdate(@RequestBody User user) {
        userService.saveOrUpdate(user);
        return Response.successResposne();
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "用户权限删除")
    @RequiredPermission(value = "delete", des = "用户权限删除")
    public Response delete(Long id) {
        userService.delete(id);
        return Response.successResposne();
    }


    @GetMapping("/findAll")
    @ApiOperation("用户列表")
    @RequiredPermission(value = "findAll", des = "用户列表")
    public Response<List<User>> findAll() {
        List<User> all = userService.findAll();
        return Response.successResposne().setData(all);
    }
}
