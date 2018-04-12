package com.wangmiao.demo.pagemodel.req;

public class FillInfoReq {

    private String name;
    private String address;
    private String email;
    private int phonenumber;
    private String sex;
    private int age;
    private String enducationDegree;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEnducationDegree() {
        return enducationDegree;
    }

    public void setEnducationDegree(String enducationDegree) {
        this.enducationDegree = enducationDegree;
    }
}
