package config;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//Spring boot方式
@EnableTransactionManagement
@Configuration
public class MybatisPlusConfig {
    Logger logger = LoggerFactory.getLogger(MybatisPlusConfig.class);
    /**
     * 分页插件
     */
    @Bean(name = "Page")
    public PaginationInterceptor paginationInterceptor() {
            logger.info("paginationInterceptor");
        return new PaginationInterceptor();
    }
}