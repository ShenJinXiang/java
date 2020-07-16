package com.shenjinxiang.spb.service;

import com.shenjinxiang.spb.domain.Book;

import java.util.List;

/**
 * @Author: ShenJinXiang
 * @Date: 2020/4/28 16:19
 */
public interface BookService {

    /**
     * 查询所有书籍
     * @return
     */
    List<Book> queryAll();

    /**
     * 根据id获取数据
     * @param id
     * @return
     */
    Book queryById(int id);

    /**
     * 新增
     * @param book
     * @return
     */
    int add(Book book);

    /**
     * 修改
     * @param book
     * @return
     */
    int upd(Book book);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    int delById(int id);
}
