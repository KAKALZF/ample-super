package com.ample16.springcloud.app.service;

import com.ample16.common.entity.Permission;

import java.util.List;

public interface PermissionService {
    void save();

    void delete(Long id);

    List<Permission> findAll();
}
