package com.shenjinxiang.spb.controller;

import com.shenjinxiang.spb.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Author: ShenJinXiang
 * @Date: 2020/4/15 08:16
 */
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/create")
    public String createTable() {
        this.bookService.createTable();
        return "OK";
    }

    @GetMapping("")
    public List<Map<String, Object>> queryAll() {
        return this.bookService.queryAll();
    }
}
