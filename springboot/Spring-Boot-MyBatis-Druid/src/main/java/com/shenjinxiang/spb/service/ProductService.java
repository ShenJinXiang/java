package com.shenjinxiang.spb.service;

import com.shenjinxiang.spb.domain.Product;

import java.util.List;

public interface ProductService {

    List<Product> queryAll();

    Product queryById(int id);

    int add(Product product);

    int update(Product product);

    int delById(int id);

    void createTable();
}
