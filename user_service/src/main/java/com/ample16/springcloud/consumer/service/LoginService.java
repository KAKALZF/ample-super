package com.ample16.springcloud.consumer.service;


import com.ample16.springcloud.consumer.entity.User;

public interface LoginService {

    User findByName(String name);
}
