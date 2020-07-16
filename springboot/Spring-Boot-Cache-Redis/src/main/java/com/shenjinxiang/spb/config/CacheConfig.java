package com.shenjinxiang.spb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: ShenJinXiang
 * @Date: 2020/4/20 09:00
 */
@Configuration
@EnableCaching
public class CacheConfig extends CachingConfigurerSupport {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    @Bean
    public KeyGenerator keyGenerator() {
        // 当没有指定缓存的 key时来根据类名、方法名和方法参数来生成key
        return (target, method, params) -> {
            StringBuilder sb = new StringBuilder();
            sb.append(target.getClass().getName())
                    .append(':')
                    .append(method.getName());
            if (params.length > 0) {
                sb.append('[');
                for (Object obj : params) {
                    if (obj != null) {
                        sb.append(obj.toString());
                    }
                }
                sb.append(']');
            }
            return sb.toString();
        };
    }


    @Override
    @Bean
    public CacheManager cacheManager() {
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(redisTemplate.getKeySerializer()))        //key序列化方式
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(redisTemplate.getValueSerializer()))    //value序列化方式
                .entryTtl(Duration.ofHours(1)) // 设置缓存有效期一小时
                .disableCachingNullValues(); //不缓存null值

        // 设置一个初始化的缓存名称set集合
        Set<String> cacheNames =  new HashSet<>();
        cacheNames.add("user");

        // 对每个缓存名称应用不同的配置，自定义过期时间
        Map<String, RedisCacheConfiguration> configMap = new HashMap<>();
        configMap.put("user", redisCacheConfiguration.entryTtl(Duration.ofSeconds(120)));

        RedisCacheManager redisCacheManager = RedisCacheManager
                .builder(RedisCacheWriter.nonLockingRedisCacheWriter(redisTemplate.getConnectionFactory()))
//                .builder(redisConnectionFactory)
                .cacheDefaults(redisCacheConfiguration)
//                .initialCacheNames(cacheNames)
//                .withInitialCacheConfigurations(configMap)
                .build();
        return redisCacheManager;
    }

}
