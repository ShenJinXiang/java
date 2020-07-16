package com.shenjinxiang.spb.domain;

/**
 * @Author: ShenJinXiang
 * @Date: 2020/4/9 17:58
 */
public class Student {

    private String name;
    private int age;
    private int gender;
    private String description;

    public Student(String name, int age, int gender, String description) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.description = description;
    }

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

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
