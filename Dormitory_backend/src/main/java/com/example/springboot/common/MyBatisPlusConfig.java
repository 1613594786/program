package com.example.springboot.common;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class MyBatisPlusConfig {

    /**
     * 配置MyBatis Plus的分页插件。
     * MyBatis Plus的分页插件可以优化数据库查询，减少内存和数据库的压力。
     * 一级缓存和二级缓存遵循MyBatis的规则。
     * 为了防止缓存问题，需要在Mybatis配置中设置useDeprecatedExecutor属性为false。
     * 这个属性在旧版分页插件被移除后也会被移除。
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        // 创建MyBatis Plus拦截器实例
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();

        // 添加内嵌拦截器，这里添加的是分页拦截器，指定数据库类型为MYSQL
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));

        // 返回配置好的拦截器实例
        return interceptor;
    }
}
