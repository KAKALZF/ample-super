package com.ample16.springcloud.consumer.common.req;

public class LoginReq {
    private String name;
    private String password;

    public String getPassword() {
        return password;
    }

    public LoginReq setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getName() {
        return name;
    }

    public LoginReq setName(String name) {
        this.name = name;
        return this;
    }
}
