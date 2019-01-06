package com.ample16.springcloud.manager.exception;

import com.ample16.common.Response;
import com.ample16.common.exception.ApplicationException;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class AutoExceptionHandler {
    @ExceptionHandler(value = ApplicationException.class)
    @ResponseBody
    public Response applicationExceptionHandler(Exception exception) {
        System.out.println("应用异常处理");
        exception.printStackTrace();
        return new Response().setCode(-1).setDes(exception.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Response exceptionHandler(Exception exception) {
        System.out.println("未知异常处理");
        exception.printStackTrace();
        return new Response().setCode(-1).setDes(exception.getMessage());
    }

    @ExceptionHandler(value = AuthorizationException.class)
    @ResponseBody
    public Response authorizationExceptionHandler(Exception exception) {
        System.out.println("===shiro定义的没授权转发没生效，这里捕捉无权限的异常===");
        exception.printStackTrace();
        return new Response().setCode(403).setDes("未授权");
    }

}
