package com.ample16.springcloud.consumer.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Permission {
    @Id
    @GeneratedValue
    public Long id;
    public String name;
    public String des;

    public Long getId() {
        return id;
    }

    public Permission setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Permission setName(String name) {
        this.name = name;
        return this;
    }

    public String getDes() {
        return des;
    }

    public Permission setDes(String des) {
        this.des = des;
        return this;
    }

}
