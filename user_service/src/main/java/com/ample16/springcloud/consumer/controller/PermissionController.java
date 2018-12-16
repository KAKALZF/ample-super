package com.ample16.springcloud.consumer.controller;

import com.ample16.springcloud.consumer.entity.Permission;
import com.ample16.springcloud.consumer.entity.Role;
import com.ample16.springcloud.consumer.service.PermissionService;
import com.ample16.springcloud.consumer.service.serviceimpl.RequiredPermission;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perm")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    @PostMapping("/save")
    @RequiredPermission(value = "loadPerm", des = "权限加载")
    @ApiOperation(value = "权限加载")
    public String save() {
        permissionService.save();
        return "success";
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "权限删除")
    public String delete(Long id) {
        permissionService.delete(id);
        return "success";
    }

    @GetMapping("/findAll")
    @RequiredPermission(value = "findAll", des = "查询所有权限")
    @ApiOperation(value = "权限列表")
    public List<Permission> findAll() {
        return permissionService.findAll();
    }
}
