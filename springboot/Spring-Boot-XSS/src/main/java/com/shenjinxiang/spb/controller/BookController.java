package com.shenjinxiang.spb.controller;

import com.shenjinxiang.spb.domain.Book;
import com.shenjinxiang.spb.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author: ShenJinXiang
 * @Date: 2020/4/28 16:22
 */
@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("")
    public String index(Model model) {
//        List<Book> books = this.bookService.queryAll();
//        model.addAttribute("bookList", books);
        return "book/index";
    }

    @ResponseBody
    @GetMapping("/all")
    public List<Book> all() {
        List<Book> books = this.bookService.queryAll();
        return books;
    }

    @GetMapping("/addPage")
    public String addPage() {
        return "book/add.html";
    }

    @PostMapping("/add")
    public ModelAndView addBook(Book book) {
        ModelAndView mv = new ModelAndView();
        bookService.add(book);
        mv.setViewName("redirect:/books");
        return mv;
    }
}
