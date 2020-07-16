package com.shenjinxiang.spb.controller;

import com.shenjinxiang.spb.domain.Book;
import com.shenjinxiang.spb.exceptions.BookNotExistException;
import com.shenjinxiang.spb.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author: ShenJinXiang
 * @Date: 2020/5/11 15:51
 */
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("")
    public String books() {
        if (true) {
            throw new RuntimeException("book Biz error");
        }
        return "books";
    }

    @GetMapping("/{id}")
    public Book queryById(@PathVariable int id) {
        Book book = bookService.queryById(id);
        if (null == book) {
            throw new BookNotExistException(id);
        }
        return book;
    }
}
