package com.ample16.springcloud.consumer.service.serviceimpl;

import com.ample16.springcloud.consumer.dao.RoleDao;
import com.ample16.springcloud.consumer.dao.UserDao;
import com.ample16.springcloud.consumer.entity.User;
import com.ample16.springcloud.consumer.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;

    //查询用户通过用户名
    @Override
    public User findByName(String name) {
        return userDao.findByName(name);
    }
}