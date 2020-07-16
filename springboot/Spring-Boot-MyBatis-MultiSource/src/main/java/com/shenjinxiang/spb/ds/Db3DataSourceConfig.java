package com.shenjinxiang.spb.ds;

import com.shenjinxiang.spb.ds.config.Db3Config;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
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

    @Autowired
    private Db3Config db3Config;

    @Bean(name = "db3DataSource")
    public DataSource db3DataSource() {
        DataSource dataSource = DataSourceBuilder.create()
                .driverClassName(db3Config.getDriverClassName())
                .url(db3Config.getUrl())
                .username(db3Config.getUsername())
                .password(db3Config.getPassword())
                .build();
        return dataSource;
    }

    @Bean(name = "db3SqlSessionFactory")
    public SqlSessionFactory db3SqlSessionFactory(@Qualifier("db3DataSource") DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCATION));
        return sessionFactoryBean.getObject();
    }

    @Bean(name = "db3TransactionManager")
    public DataSourceTransactionManager db3TransactionManager(@Qualifier("db3DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
