package com.ample16.springcloud.consumer.dao;

import com.ample16.springcloud.consumer.entity.Role;
import com.ample16.springcloud.consumer.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends JpaRepository<Role,Long> {
}
