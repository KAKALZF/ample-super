package com.ample16.springcloud.app.service;

import com.ample16.common.entity.User;

import java.util.List;

public interface UserService {
    void saveOrUpdate(User user);

    void delete(Long id);


    List<User> findAll();

    void register(User user);

    User findByName(String name);
}
