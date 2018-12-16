package com.ample16.springcloud.consumer.controller;

import com.ample16.springcloud.consumer.entity.Role;
import com.ample16.springcloud.consumer.entity.User;
import com.ample16.springcloud.consumer.service.RoleService;
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
    public String save(@RequestBody Role role) {
        roleService.saveUpdate(role);
        return "success";
    }

    @DeleteMapping("/delete")
    @ApiOperation("角色删除")
    public String delete(Long id) {
        roleService.delete(id);
        return "success";
    }

    @GetMapping("/findAll")
    @ApiOperation("角色列表")
    public List<Role> findAll() {
        return roleService.findAll();
    }
}
