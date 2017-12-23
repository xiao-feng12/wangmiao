package com.wangmiao.demo.entity;


import javax.persistence.*;

/**
 * Created by Administrator on 2017/9/10.
 */
@Entity
@Table(name = "users", schema = "test")
public class User {
    private long uId;
    private String name;
    private Integer age;
    private String sex;

    @Id
    @Column(name = "u_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getuId() {
        return uId;
    }

    public void setuId(long uId) {
        this.uId = uId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Basic
    @Column(name = "sex")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
