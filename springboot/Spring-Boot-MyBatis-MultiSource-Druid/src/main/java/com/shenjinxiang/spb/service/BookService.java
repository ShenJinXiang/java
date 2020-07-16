package com.shenjinxiang.spb.service;

import com.shenjinxiang.spb.domain.Book;

import java.util.List;

/**
 * @Author: ShenJinXiang
 * @Date: 2020/4/3 17:45
 */
public interface BookService {

    /**
     * 获取所有
     *
     * @return
     */
    List<Book> queryAllBook();

    /**
     * 查询单条
     *
     * @param id
     * @return
     */
    Book queryById(int id);

    /**
     * 新增
     *
     * @param book
     * @return
     */
    int add(Book book);

    /**
     * 修改
     *
     * @param book
     * @return
     */
    int upd(Book book);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    int delById(int id);

}
