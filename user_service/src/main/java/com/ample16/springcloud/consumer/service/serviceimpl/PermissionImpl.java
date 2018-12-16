package com.ample16.springcloud.consumer.service.serviceimpl;

import com.ample16.springcloud.consumer.dao.PermissionDao;
import com.ample16.springcloud.consumer.entity.Permission;
import com.ample16.springcloud.consumer.service.PermissionService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;
import java.util.List;

@Service
public class PermissionImpl implements PermissionService, ApplicationContextAware {
    @Autowired
    private PermissionDao permissionDao;
    private ApplicationContext applicationContext;
    private final String PREFIX = "com.ample16.springcloud.consumer.controller.";

    @Override
    public void save() {
        String[] beanNames = applicationContext.getBeanNamesForAnnotation(RestController.class);
        for (String beanName : beanNames) {
            //类名首字母大写
            char[] chars = beanName.toCharArray();
            chars[0] -= 32;
            beanName = PREFIX + String.valueOf(chars);
            try {
                Class<?> beanClz = Class.forName(beanName);
                Method[] methods = beanClz.getMethods();
                for (Method method : methods) {
                    //为什么该标签放到annotation包获取不到?
                    if (method.isAnnotationPresent(RequiredPermission.class)) {
                        RequiredPermission annotation = method.getAnnotation(RequiredPermission.class);
                        String value = annotation.value();
                        System.out.println(value);
                        Permission permission = new Permission().setDes(beanName + ":" + value);
                        permissionDao.save(permission);
                    }
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        System.out.println("权限加载完毕...");
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Permission perm) {

    }

    @Override
    public List<Permission> findAll() {
        return permissionDao.findAll();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }


}
