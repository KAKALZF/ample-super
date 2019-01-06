package com.ample16.springcloud.user.service.serviceimpl;

import com.ample16.springcloud.user.dao.PermissionDao;
import com.ample16.springcloud.user.dao.RoleDao;
import com.ample16.common.entity.Permission;
import com.ample16.common.entity.Role;
import com.ample16.springcloud.user.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private PermissionDao permissionDao;

    @Override
    public void saveUpdate(Role role) {
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
    public List<Role> findAll() {
        return roleDao.findAll();
    }
}
