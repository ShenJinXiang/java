package com.shenjinxiang.spb.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.text.SimpleDateFormat;

/**
 * @Author: ShenJinXiang
 * @Date: 2020/4/21 09:08
 */
@Configuration
public class JacksonConfig {

    @Bean(name = "objectMapper")
    @Primary
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        return mapper;
    }

    @Bean(name = "objectMapper1")
    public ObjectMapper objectMapper1() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        return mapper;
    }
}
