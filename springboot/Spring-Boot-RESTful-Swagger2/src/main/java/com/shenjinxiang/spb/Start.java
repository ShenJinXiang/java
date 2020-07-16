package com.shenjinxiang.spb;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: ShenJinXiang
 * @Date: 2020/4/12 22:17
 */
@SpringBootApplication
public class Start {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(Start.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
    }
}
