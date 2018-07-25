package com.wangmiao.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_organization" ,schema = "sybnew")
public class Organization {
    private long id;
    private String name;

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


}
