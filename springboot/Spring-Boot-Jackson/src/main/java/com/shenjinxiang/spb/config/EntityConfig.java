package com.shenjinxiang.spb.config;

import com.shenjinxiang.spb.domain.User;
import com.shenjinxiang.spb.domain.User1;
import com.shenjinxiang.spb.domain.User2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

/**
 * @Author: ShenJinXiang
 * @Date: 2020/4/21 10:29
 */
@Configuration
public class EntityConfig {


    @Bean
    public User createUser() {
        User user = new User();
        user.setName("张三");
        user.setAge(19);
        user.setBirthday(new Date());
        user.setPassword("123123123");
        user.setAddress("北京");
        return user;
    }

    @Bean
    public User1 createUser1() {
        User1 user = new User1();
        user.setName("李四");
        user.setAge(29);
        user.setBirthday(new Date());
        user.setPassword("abcdef");
        user.setAddress("上海");
        return user;
    }

    @Bean
    public User2 createUser2() {
        User2 user = new User2();
        user.setName("王五");
        user.setAge(39);
        user.setBirthday(new Date());
        user.setPassword("abcdef");
        user.setAddress("上海");
        return user;
    }
}
