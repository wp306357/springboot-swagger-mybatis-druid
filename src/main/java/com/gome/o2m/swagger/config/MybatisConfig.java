package com.gome.o2m.swagger.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

/**
 * @author wangpeng24
 * @date 2017/6/6 15:26
 * @Copyright(c) gome inc Gome Co.,LTD
 */
@Configuration
@EnableTransactionManagement
public class MybatisConfig implements TransactionManagementConfigurer {

    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return null;
    }
}
