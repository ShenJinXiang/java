package com.shenjinxiang.spb.domain;

import java.io.Serializable;

/**
 * @Author: ShenJinXiang
 * @Date: 2020/4/16 17:22
 */
public class Book implements Serializable {

    private int id;
    private String name;
    private String author;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
