package com.ample16.springcloud.consumer.service;

import com.ample16.springcloud.consumer.entity.User;

import java.util.List;

public interface UserService {
    void save(User user);

    void delete(Long id);

    void update(User user);

    List<User> findAll();
}
