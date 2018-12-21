package com.ample16.springcloud.consumer.common.req;

public class RegisterReq {
    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public RegisterReq setName(String name) {
        this.name = name;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public RegisterReq setPassword(String password) {
        this.password = password;
        return this;
    }
}
