package com.shenjinxiang.spb.controller;

import com.shenjinxiang.spb.domain.Book;
import com.shenjinxiang.spb.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: ShenJinXiang
 * @Date: 2020/4/3 17:51
 */
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("")
    public List<Book> queryAll() {
        return this.bookService.queryAllBook();
    }

    @GetMapping("/{id}")
    public Book queryById(@PathVariable int id) {
        return this.bookService.queryById(id);
    }

    @PostMapping("")
    public int postUser(@RequestBody Book book) {
        return this.bookService.add(book);
    }

    @PutMapping("/{id}")
    public int putUser(@PathVariable int id, @RequestBody Book book) {
        Book book1 = this.bookService.queryById(id);
        book1.setName(book.getName());
        book1.setAuthor(book.getAuthor());
        return this.bookService.upd(book1);
    }

    @DeleteMapping("/{id}")
    public int deleteUser(@PathVariable int id) {
        return this.bookService.delById(id);
    }
}
