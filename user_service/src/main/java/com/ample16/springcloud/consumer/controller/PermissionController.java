package com.ample16.springcloud.consumer.controller;

import com.ample16.springcloud.consumer.entity.Permission;
import com.ample16.springcloud.consumer.entity.Role;
import com.ample16.springcloud.consumer.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/perm")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/save")
    public String save() {
        permissionService.save();
        return "success";
    }

    @RequestMapping("/delete")
    public String delete() {
        return "";
    }


    @RequestMapping("/update")
    public String update(Permission perm) {
        return "";
    }

    @RequestMapping("/findAll")
    public List<Permission> findAll() {
        return permissionService.findAll();
    }
}
