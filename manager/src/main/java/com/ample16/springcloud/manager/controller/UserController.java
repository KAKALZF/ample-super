package com.ample16.springcloud.manager.controller;

import com.ample16.common.Response;
import com.ample16.common.entity.User;
import com.ample16.common.req.user.RegisterReq;
import com.ample16.springcloud.manager.client.UserClient;
import com.ample16.springcloud.manager.shiro.util.PasswordHelper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserClient userClient;

    /*注册账号/密码:root/admin*/
    @PostMapping("/register")
    @ApiOperation(value = "用户注册")
    public Response register(@RequestBody RegisterReq registerReq) {
        User user = new User()
                .setName(registerReq.getName())
                .setPassword(registerReq.getPassword());
        PasswordHelper.encryptPassword(user);
        userClient.register(registerReq.setName(user.getName()).setPassword(user.getPassword()));
        return Response.successResposne();
    }
}
