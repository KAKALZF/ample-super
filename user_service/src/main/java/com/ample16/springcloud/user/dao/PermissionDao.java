package com.ample16.springcloud.user.dao;

import com.ample16.common.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionDao extends JpaRepository<Permission,Long> {
}
