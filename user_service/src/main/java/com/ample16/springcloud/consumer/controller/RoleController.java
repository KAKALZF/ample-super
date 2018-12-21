package com.ample16.springcloud.consumer.controller;

import com.ample16.common.Response;
import com.ample16.springcloud.consumer.entity.Role;
import com.ample16.springcloud.consumer.service.RoleService;
import com.ample16.springcloud.consumer.service.serviceimpl.RequiredPermission;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping("/save")
    @ApiOperation("角色保存")
    @RequiredPermission(value = "save", des = "角色保存")
    public Response save(@RequestBody Role role) {
        roleService.saveUpdate(role);
        return Response.successResposne();
    }

    @DeleteMapping("/delete")
    @ApiOperation("角色删除")
    @RequiredPermission(value = "delete", des = "角色删除")
    public Response delete(Long id) {
        roleService.delete(id);
        return Response.successResposne();
    }

    @GetMapping("/findAll")
    @ApiOperation("角色列表")
    @RequiredPermission(value = "findAll", des = "角色列表")
    public Response<List<Role>> findAll() {
        return Response.successResposne().setData(roleService.findAll());
    }
}
