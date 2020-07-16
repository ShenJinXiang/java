package com.shenjinxiang.spb.service.impl;

import com.shenjinxiang.spb.domain.Book;
import com.shenjinxiang.spb.mapper.db3.BookMapper;
import com.shenjinxiang.spb.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ShenJinXiang
 * @Date: 2020/4/3 17:46
 */
@Service("bookService")
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> queryAllBook() {
        return this.bookMapper.queryAllBook();
    }

    @Override
    public Book queryById(int id) {
        return this.bookMapper.queryById(id);
    }

    @Override
    public int add(Book book) {
        return this.bookMapper.add(book);
    }

    @Override
    public int upd(Book book) {
        return this.bookMapper.upd(book);
    }

    @Override
    public int delById(int id) {
        return this.bookMapper.delById(id);
    }
}
