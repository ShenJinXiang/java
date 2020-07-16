package com.shenjinxiang.spb;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: ShenJinXiang
 * @Date: 2020/6/22 06:22
 */
@SpringBootApplication
public class Application {

//    http://www.iocoder.cn/Spring-Boot/Job/?github

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Application.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
    }
}
