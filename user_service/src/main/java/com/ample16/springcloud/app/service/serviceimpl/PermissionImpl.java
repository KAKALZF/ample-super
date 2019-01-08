package com.ample16.springcloud.app.service.serviceimpl;

import com.ample16.springcloud.app.dao.PermissionDao;
import com.ample16.common.entity.Permission;
import com.ample16.springcloud.app.service.PermissionService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.List;

@Service
public class PermissionImpl implements PermissionService, ApplicationContextAware {
    @Autowired
    private PermissionDao permissionDao;
    private ApplicationContext applicationContext;
    private final String PREFIX = "com.ample16.springcloud.app.controller.";

    @Override
    public void save() {
        List<Permission> permAll = permissionDao.findAll();
        HashSet<String> permSet = new HashSet<>();
        for (Permission perm : permAll) {
            permSet.add(perm.getName());
        }
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
                        String permName = beanName + ":" + annotation.value();
                        if (!permSet.contains(permName)) {
                            Permission permission = new Permission()
                                    .setName(permName)
                                    .setDes(annotation.des());
                            permissionDao.save(permission);
                        }
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
        permissionDao.delete(id);
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
