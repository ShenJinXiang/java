package com.shenjinxiang.spb.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Mapper
public interface BookMapper {

    void createTable();

    List<Map<String, Object>> queryAll();

}
