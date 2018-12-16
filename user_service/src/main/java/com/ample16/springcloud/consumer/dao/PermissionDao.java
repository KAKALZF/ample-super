package com.ample16.springcloud.consumer.dao;

import com.ample16.springcloud.consumer.entity.Permission;
import com.ample16.springcloud.consumer.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionDao extends JpaRepository<Permission,Long> {
}
