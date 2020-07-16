package com.shenjinxiang.spb.ds;

import com.shenjinxiang.spb.ds.config.Db2Config;
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
@MapperScan(basePackages = Db2DataSourceConfig.MAPPER_PACKAGE, sqlSessionFactoryRef = "db2SqlSessionFactory")
public class Db2DataSourceConfig {

    static final String MAPPER_PACKAGE = "com.shenjinxiang.spb.mapper.db2";
    static final String MAPPER_LOCATION = "classpath:mapper/db2/*Mapper.xml";

    @Autowired
    private Db2Config db2Config;

    @Bean(name = "db2DataSource")
    public DataSource db2DataSource() {
        DataSource dataSource = DataSourceBuilder.create()
                .driverClassName(db2Config.getDriverClassName())
                .url(db2Config.getUrl())
                .username(db2Config.getUsername())
                .password(db2Config.getPassword())
                .build();
        return dataSource;
    }

    @Bean(name = "db2SqlSessionFactory")
    public SqlSessionFactory db2SqlSessionFactory(@Qualifier("db2DataSource") DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCATION));
        return sessionFactoryBean.getObject();
    }

    @Bean(name = "db2TransactionManager")
    public DataSourceTransactionManager db2TransactionManager(@Qualifier("db2DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
