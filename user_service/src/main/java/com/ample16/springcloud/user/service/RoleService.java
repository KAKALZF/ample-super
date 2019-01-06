package com.ample16.springcloud.user.service;

import com.ample16.common.entity.Role;

import java.util.List;

public interface RoleService {
    void saveUpdate(Role role);

    void delete(Long id);

    List<Role> findAll();
}
