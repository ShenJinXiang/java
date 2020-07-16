package com.shenjinxiang.spb.service;

import java.util.List;
import java.util.Map;

/**
 * @Author: ShenJinXiang
 * @Date: 2020/4/15 08:19
 */
public interface BookService {

    void createTable();

    List<Map<String, Object>> queryAll();
}
