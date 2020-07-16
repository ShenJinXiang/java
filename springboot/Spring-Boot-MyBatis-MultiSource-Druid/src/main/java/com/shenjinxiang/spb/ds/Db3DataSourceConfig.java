package com.shenjinxiang.spb.ds;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @Author: ShenJinXiang
 * @Date: 2020/4/3 14:29
 */
@Configuration
@MapperScan(basePackages = Db3DataSourceConfig.MAPPER_PACKAGE, sqlSessionFactoryRef = "db3SqlSessionFactory")
public class Db3DataSourceConfig {

    static final String MAPPER_PACKAGE = "com.shenjinxiang.spb.mapper.db3";
    static final String MAPPER_LOCATION = "classpath:mapper/db3/*Mapper.xml";

    @Bean(name = "db3DataSource")
    @ConfigurationProperties("spring.datasource.druid.db3")
    public DataSource db3DataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "db3SqlSessionFactory")
    public SqlSessionFactory db3SqlSessionFactory(@Qualifier("db3DataSource") DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        // 如果不使用xml的方式配置mapper，可以
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCATION));
        return sessionFactoryBean.getObject();
    }

    @Bean(name = "db3TransactionManager")
    public DataSourceTransactionManager db3TransactionManager(@Qualifier("db3DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
