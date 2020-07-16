package com.shenjinxiang.spb.ds;

import com.shenjinxiang.spb.ds.config.Db1Config;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @Author: ShenJinXiang
 * @Date: 2020/4/3 14:29
 */
@Configuration
@MapperScan(basePackages = Db1DataSourceConfig.MAPPER_PACKAGE, sqlSessionFactoryRef = "db1SqlSessionFactory")
public class Db1DataSourceConfig {

    static final String MAPPER_PACKAGE = "com.shenjinxiang.spb.mapper.db1";
    static final String MAPPER_LOCATION = "classpath:mapper/db1/*Mapper.xml";

    @Autowired
    private Db1Config db1Config;

    @Primary
    @Bean(name = "db1DataSource")
    public DataSource db1DataSource() {
        DataSource dataSource = DataSourceBuilder.create()
                .driverClassName(db1Config.getDriverClassName())
                .url(db1Config.getUrl())
                .username(db1Config.getUsername())
                .password(db1Config.getPassword())
                .build();
        return dataSource;
    }

    @Primary
    @Bean(name = "db1SqlSessionFactory")
    public SqlSessionFactory db1SqlSessionFactory(@Qualifier("db1DataSource") DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCATION));
        return sessionFactoryBean.getObject();
    }

    @Primary
    @Bean(name = "db1TransactionManager")
    public DataSourceTransactionManager db1TransactionManager(@Qualifier("db1DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
