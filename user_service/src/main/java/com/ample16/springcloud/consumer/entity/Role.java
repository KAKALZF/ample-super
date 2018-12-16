package com.ample16.springcloud.consumer.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Role {
    @Id
    @GeneratedValue
    public Long id;
    public String name;
    public String des;
    @ManyToMany
    public List<Permission> permissions;
    @Transient
    public List<Long> permissionIds;

    public Long getId() {
        return id;
    }

    public Role setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Role setName(String name) {
        this.name = name;
        return this;
    }

    public String getDes() {
        return des;
    }

    public Role setDes(String des) {
        this.des = des;
        return this;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public Role setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
        return this;
    }

    public List<Long> getPermissionIds() {
        return permissionIds;
    }

    public Role setPermissionIds(List<Long> permissionIds) {
        this.permissionIds = permissionIds;
        return this;
    }
}
