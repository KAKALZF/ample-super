package com.ample16.springcloud.consumer.controller;

import com.ample16.springcloud.consumer.common.req.LoginReq;
import com.ample16.springcloud.consumer.service.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    //未登陆就访问的页面
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "please login first";
    }

    //post登录
    @PostMapping(value = "/login")
    public String login(@RequestBody LoginReq req) {
        //添加用户认证信息
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(
                req.getName(),
                req.getPassword());
        //进行验证，这里可以捕获异常，然后返回对应信息
        subject.login(usernamePasswordToken);
        return "login success";
    }

    @GetMapping(value = "/index")
    public String index() {
        return "登录成功";
    }

    //登出
    @GetMapping(value = "/logout")
    public String logout() {
        System.out.println("退出登录");
        Subject subject = SecurityUtils.getSubject();
        Object principal = subject.getPrincipal();
        System.out.println("将要退出的用户是:" + principal.toString());
        subject.logout();
        return "logout successful";
    }

    //错误页面展示
    @RequestMapping(value = "/error", method = RequestMethod.POST)
    public String error() {
        return "用户未授权!";
    }



    //注解的使用
    @GetMapping(value = "/sessionTime")
    public String sessionTime() {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        long timeout = session.getTimeout();
        System.out.println("默认超时时间:" + timeout);
        System.out.println("sessionId:" + session.getId());
        session.setTimeout(1000L * 5);
        return "Create success!";
    }
}