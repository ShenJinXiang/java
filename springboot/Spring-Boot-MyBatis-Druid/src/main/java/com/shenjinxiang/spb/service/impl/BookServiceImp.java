package com.shenjinxiang.spb.service.impl;

import com.shenjinxiang.spb.mapper.BookMapper;
import com.shenjinxiang.spb.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: ShenJinXiang
 * @Date: 2020/4/15 08:20
 */
@Service("bookService")
public class BookServiceImp implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public void createTable() {
        bookMapper.createTable();
    }

    @Override
    public List<Map<String, Object>> queryAll() {
        return this.bookMapper.queryAll();
    }
}
