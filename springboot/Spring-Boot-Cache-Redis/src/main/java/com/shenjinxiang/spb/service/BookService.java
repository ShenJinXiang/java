package com.shenjinxiang.spb.service;

import com.shenjinxiang.spb.domain.Book;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * @Author: ShenJinXiang
 * @Date: 2020/4/16 17:29
 */
@CacheConfig(cacheNames = "book", cacheManager="cacheManager")
public interface BookService {

    /**
     * 查询所有书籍
     *
     * @return
     */
    List<Book> queryAll();

    /**
     * 根据id获取数据
     *
     * @param id
     * @return
     */
    @Cacheable(key = "#p0")
    Book queryById(int id);

    /**
     * 新增
     *
     * @param book
     * @return
     */
    Book add(Book book);

    /**
     * 修改
     *
     * @param book
     * @return
     */
    @CachePut(key = "#p0.id")
    Book upd(Book book);

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    @CacheEvict(key = "#p0", allEntries = true)
    int delById(int id);

}
