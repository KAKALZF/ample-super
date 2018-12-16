package com.ample16.springcloud.consumer.service;

import com.ample16.springcloud.consumer.entity.Permission;
import com.ample16.springcloud.consumer.entity.Role;

import java.util.List;

public interface RoleService {
    void save(Role role);

    void delete(Long id);

    void update(Role role);

    List<Role> findAll();
}
