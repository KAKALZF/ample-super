package com.ample16.springcloud.consumer.service.serviceimpl;

import com.ample16.springcloud.consumer.dao.RoleDao;
import com.ample16.springcloud.consumer.dao.UserDao;
import com.ample16.springcloud.consumer.entity.Role;
import com.ample16.springcloud.consumer.entity.User;
import com.ample16.springcloud.consumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;

    @Override
    public void save(User user) {
        List<Long> roleIds = user.getRoleIds();
        List<Role> roleList = roleDao.findAll(roleIds);
        user.setRoles(roleList);
        userDao.save(user);
    }

    @Override
    public void delete(Long id) {
        userDao.delete(id);
    }

    @Override
    public void update(User user) {

    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}
