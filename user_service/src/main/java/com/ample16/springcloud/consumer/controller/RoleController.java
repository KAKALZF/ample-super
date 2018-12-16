package com.ample16.springcloud.consumer.controller;

import com.ample16.springcloud.consumer.entity.Role;
import com.ample16.springcloud.consumer.entity.User;
import com.ample16.springcloud.consumer.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping("/save")
    public String save(Role role) {
        roleService.save(role);
        return "success";
    }

    @RequestMapping("/delete")
    public String delete() {

        return "";
    }


    @RequestMapping("/update")
    public String update(Role role) {
        return "";
    }

    @RequestMapping("/findAll")
    public List<Role> findAll() {
        return roleService.findAll();
    }
}
