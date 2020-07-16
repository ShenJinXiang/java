package com.shenjinxiang.spb.controller;

import com.shenjinxiang.spb.domain.Product;
import com.shenjinxiang.spb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public String createTable() {
        this.productService.createTable();
        return "OK";
    }

    @GetMapping("")
    public List<Product> queryAll() {
        return this.productService.queryAll();
    }

    @GetMapping("/{id}")
    public Product queryById(@PathVariable("id") int id) {
        return this.productService.queryById(id);
    }

    @PostMapping("")
    public int add(@RequestBody Product product) {
        return this.productService.add(product);
    }

    @PutMapping("/{id}")
    public int update(@PathVariable int id, @RequestBody Product product) {
        return this.productService.update(product);
    }

    @DeleteMapping("/{id}")
    public int delById(@PathVariable("id") int id) {
        return this.productService.delById(id);
    }
}
