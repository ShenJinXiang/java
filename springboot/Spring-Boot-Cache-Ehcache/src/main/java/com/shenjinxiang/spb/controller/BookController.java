package com.shenjinxiang.spb.controller;

import com.shenjinxiang.spb.domain.Book;
import com.shenjinxiang.spb.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: ShenJinXiang
 * @Date: 2020/4/16 17:24
 */
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("")
    public List<Book> index() {
        return bookService.queryAll();
    }

    @GetMapping("/{id}")
    public Book queryById(@PathVariable int id) {
        return bookService.queryById(id);
    }

    @PostMapping("")
    public Book add(@RequestBody Book book) {
        return bookService.add(book);
    }

    @PutMapping("/{id}")
    public Book upd(@PathVariable int id, @RequestBody Book book) {
        Book dbBook = bookService.queryById(id);
        dbBook.setName(book.getName());
        dbBook.setAuthor(book.getAuthor());
        return bookService.upd(dbBook);
    }

    @DeleteMapping("/{id}")
    public int delById(@PathVariable int id) {
        return bookService.delById(id);
    }
}
