package com.example.springboot.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    // 构建CORS配置的方法
    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration(); // 创建CORS配置对象

        // 允许任何域名进行跨域请求
        corsConfiguration.addAllowedOrigin("*");
        // 允许任何头信息的跨域请求
        corsConfiguration.addAllowedHeader("*");
        // 允许任何HTTP方法的跨域请求
        corsConfiguration.addAllowedMethod("*");

        return corsConfiguration; // 返回配置对象
    }

    // 定义CORS过滤器的Bean
    @Bean
    public CorsFilter corsFilter() {
        // 创建基于URL的CORS配置源
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        // 为所有请求路径注册CORS配置
        source.registerCorsConfiguration("/**", buildConfig());

        // 创建CorsFilter并返回
        return new CorsFilter(source);
    }
}