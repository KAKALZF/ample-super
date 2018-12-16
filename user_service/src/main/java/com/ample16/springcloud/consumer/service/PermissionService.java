package com.ample16.springcloud.consumer.service;

import com.ample16.springcloud.consumer.entity.Permission;
import com.ample16.springcloud.consumer.entity.User;

import java.util.List;

public interface PermissionService {
    void save();

    void delete(Long id);

    void update(Permission perm);

    List<Permission> findAll();
}
