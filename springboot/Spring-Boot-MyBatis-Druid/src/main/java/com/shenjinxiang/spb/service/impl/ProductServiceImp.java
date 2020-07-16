package com.shenjinxiang.spb.service.impl;

import com.shenjinxiang.spb.domain.Product;
import com.shenjinxiang.spb.mapper.ProductMapper;
import com.shenjinxiang.spb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("productService")
public class ProductServiceImp implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> queryAll() {
        return this.productMapper.queryAll();
    }

    @Override
    public Product queryById(int id) {
        return this.productMapper.queryById(id);
    }

    @Override
    public int add(Product product) {
        return this.productMapper.add(product);
    }

    @Override
    public int update(Product product) {
        return this.productMapper.upd(product);
    }

    @Override
    public int delById(int id) {
        return this.productMapper.delById(id);
    }

    @Override
    public void createTable() {
        this.productMapper.createTable();
    }
}
