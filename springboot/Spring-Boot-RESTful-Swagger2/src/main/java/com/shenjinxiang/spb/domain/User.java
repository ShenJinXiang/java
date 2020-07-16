package com.shenjinxiang.spb.domain;

/**
 * @Author: ShenJinXiang
 * @Date: 2020/4/12 22:26
 */
public class User {

    private Long id;
    private String name;
    private Integer age;
    private String desc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
