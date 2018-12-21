package com.ample16.springcloud.consumer.exception;

import com.ample16.common.Response;
import com.ample16.common.exception.ApplicationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class AutoExceptionHandler {
    @ExceptionHandler(value = ApplicationException.class)
    public Response applicationExceptionHandler(HttpServletRequest request, Exception exception) {
        System.out.println("应用异常处理");
        return new Response().setCode(-1).setDes(exception.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public Response exceptionHandler(HttpServletRequest request, Exception exception) {
        System.out.println("未知异常处理");
        return new Response().setCode(-1).setDes(exception.getMessage());
    }

}
