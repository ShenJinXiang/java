package com.shenjinxiang.spb.service.impl;

import com.shenjinxiang.spb.domain.Book;
import com.shenjinxiang.spb.mapper.BookMapper;
import com.shenjinxiang.spb.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ShenJinXiang
 * @Date: 2020/4/16 17:30
 */
@Service("bookService")
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> queryAll() {
        return bookMapper.queryAll();
    }

    @Override
    public Book queryById(int id) {
        return bookMapper.queryById(id);
    }

    @Override
    public Book add(Book book) {
        bookMapper.add(book);
        return book;
    }

    @Override
    public Book upd(Book book) {
        bookMapper.upd(book);
        return bookMapper.queryById(book.getId());
    }

    @Override
    public int delById(int id) {
        return bookMapper.delById(id);
    }
}
