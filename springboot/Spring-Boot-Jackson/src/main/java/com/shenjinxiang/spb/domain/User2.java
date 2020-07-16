package com.shenjinxiang.spb.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

/**
 * @Author: ShenJinXiang
 * @Date: 2020/4/21 08:18
 */
public class User2 {

    private String name;
    private int age;
    @JsonIgnore
    private String password;
    private Date birthday;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
