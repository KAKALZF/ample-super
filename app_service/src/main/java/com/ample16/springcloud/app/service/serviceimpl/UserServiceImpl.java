package com.ample16.springcloud.app.service.serviceimpl;

import com.ample16.springcloud.app.dao.RoleDao;
import com.ample16.springcloud.app.dao.UserDao;
import com.ample16.common.entity.Role;
import com.ample16.common.entity.User;
import com.ample16.springcloud.app.service.UserService;
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
//        PasswordHelper.encryptPassword(app);
        userDao.save(user);
    }

    @Override
    public User findByName(String name) {
        return userDao.findByName(name);
    }
}
