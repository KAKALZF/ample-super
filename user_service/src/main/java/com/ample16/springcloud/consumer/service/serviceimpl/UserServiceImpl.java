package com.ample16.springcloud.consumer.service.serviceimpl;

import com.ample16.springcloud.consumer.dao.RoleDao;
import com.ample16.springcloud.consumer.dao.UserDao;
import com.ample16.springcloud.consumer.entity.Role;
import com.ample16.springcloud.consumer.entity.User;
import com.ample16.springcloud.consumer.service.UserService;
import com.ample16.springcloud.consumer.shiro.util.PasswordHelper;
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
    public void saveOrUpdate(User user) {
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
    public List<User> findAll() {
        return userDao.findAll();
    }
    /*用户注册，创建用户*/
    @Override
    public void register(User user) {
        PasswordHelper.encryptPassword(user);
        userDao.save(user);
    }
}
