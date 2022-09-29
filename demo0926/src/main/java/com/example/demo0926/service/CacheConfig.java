package com.example.demo0926.service;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableCaching
public class CacheConfig {

    @Bean
    public KeyGenerator wiselyKeyGenerator() {
        return new KeyGenerator() {
            // key 值命名
            // Cache key 生成方式
            @Override
            public Object generate(Object target, Method method, Object... params){
                StringBuilder sb = new StringBuilder();
                sb.append(target.getClass().getName());
                sb.append(method.getName());
                for (Object obj : params) {
                    sb.append(obj.toString());
                }
                return sb.toString();
            }
        };
    }

    // Cache 管理
    // 此兩處 @Bean name 可加可不加，加的話可以方便用  @Qualifier 來觀察使用到的緩存
    @Bean(name="cacheManager")
    @Primary
    public CacheManager cacheManager() {
        ConcurrentMapCacheManager manager = new ConcurrentMapCacheManager();
        return manager;
    }

    @Bean(name="alternateCacheManager")
    public CacheManager alternateCacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
        cacheManager.setCaffeine(Caffeine.newBuilder()
                // 建立後三十秒即過期
                .expireAfterWrite(30, TimeUnit.SECONDS));
        return cacheManager;
    }
}
