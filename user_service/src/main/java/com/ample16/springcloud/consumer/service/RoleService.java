package com.ample16.springcloud.consumer.service;

import com.ample16.springcloud.consumer.entity.Permission;
import com.ample16.springcloud.consumer.entity.Role;

import java.util.List;

public interface RoleService {
    void saveUpdate(Role role);

    void delete(Long id);

    List<Role> findAll();
}
