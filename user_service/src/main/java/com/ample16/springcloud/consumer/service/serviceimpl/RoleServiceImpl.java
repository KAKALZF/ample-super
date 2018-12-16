package com.ample16.springcloud.consumer.service.serviceimpl;

import com.ample16.springcloud.consumer.dao.PermissionDao;
import com.ample16.springcloud.consumer.dao.RoleDao;
import com.ample16.springcloud.consumer.entity.Permission;
import com.ample16.springcloud.consumer.entity.Role;
import com.ample16.springcloud.consumer.entity.User;
import com.ample16.springcloud.consumer.service.RoleService;
import com.ample16.springcloud.consumer.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private RoleDao roleDao;
    private PermissionDao permissionDao;

    @Override
    public void save(Role role) {
        List<Long> permissionIds = role.getPermissionIds();
        List<Permission> permissionList = permissionDao.findAll(permissionIds);
        role.setPermissions(permissionList);
        roleDao.save(role);
    }

    @Override
    public void delete(Long id) {
        roleDao.delete(id);
    }

    @Override
    public void update(Role role) {

    }

    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }
}