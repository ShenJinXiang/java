package com.shenjinxiang.spb.mapper;

import com.shenjinxiang.spb.domain.Product;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface ProductMapper {

    void createTable();

    List<Product> queryAll();

    Product queryById(int id);

    int add(Product product);

    int upd(Product product);

    int delById(int id);
}
