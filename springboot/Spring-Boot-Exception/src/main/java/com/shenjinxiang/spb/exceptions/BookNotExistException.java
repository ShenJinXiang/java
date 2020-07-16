package com.shenjinxiang.spb.exceptions;

/**
 * @Author: ShenJinXiang
 * @Date: 2020/5/11 16:49
 */
public class BookNotExistException extends RuntimeException {

    private int id;

    public BookNotExistException(int id){
        super("book not exist");
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
