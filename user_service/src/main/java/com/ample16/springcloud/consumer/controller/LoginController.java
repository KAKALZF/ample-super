package com.ample16.springcloud.consumer.controller;

import com.ample16.common.Response;
import com.ample16.common.exception.ApplicationException;
import com.ample16.common.req.user.LoginReq;
import com.ample16.springcloud.consumer.service.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;


    //post登录
    @PostMapping(value = "/login")
    public Response login(@RequestBody LoginReq req) {
        System.out.println("=============登录post====");
        //添加用户认证信息
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(
                req.getName(),
                req.getPassword());
        //进行验证，这里可以捕获异常，然后返回对应信息
        try {
            subject.login(usernamePasswordToken);
        } catch (UnknownAccountException e) {
            throw new ApplicationException("用户名/密码错误", e);
        } catch (IncorrectCredentialsException e) {
            throw new ApplicationException("用户名/密码错误", e);
        } catch (AuthenticationException e) {
            //其他错误，比如锁定，如果想单独处理请单独catch处理
            throw new ApplicationException("验证的其他错误", e);
        }
        return Response.successResposne().setDes("login success");
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

    @GetMapping(value = "/405")
    public Response index() {
        return new Response().setDes("用户未登录").setCode(405);
    }

    //错误页面展示
    @GetMapping(value = "/403")
    public Response error() {
        System.out.println("===========/403=========");
        return new Response().setDes("用户未授权").setCode(403);
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