package help.config;

import com.baomidou.mybatisplus.entity.GlobalConfiguration;
import com.baomidou.mybatisplus.mapper.LogicSqlInjector;
import com.baomidou.mybatisplus.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.plugins.PerformanceInterceptor;
import com.baomidou.mybatisplus.plugins.SqlExplainInterceptor;
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

    /**
     * 乐观锁
     * @return
     */
    @Bean(name = "OptimisticLockerInterceptor")
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        logger.info("OptimisticLockerInterceptor");
        return new OptimisticLockerInterceptor();
    }

    /**
     * 性能分析插件
     * @return
     */
    @Bean(name = "performanceInterceptor")
    public PerformanceInterceptor performanceInterceptor() {
        logger.info("performanceInterceptor");
        PerformanceInterceptor performanceInterceptor=new PerformanceInterceptor();
        performanceInterceptor.setMaxTime(100)
                .setFormat(true);

        return performanceInterceptor;
    }
    /**
     * SQL 执行分析拦截器【 目前只支持 MYSQL-5.6.3 以上版本 】
     * ，作用是分析 处理 DELETE UPDATE 语句，
     * 防止小白或者恶意 delete update 全表操作！
     *
     *参数：stopProceed 发现执行全表 delete update 语句是否停止执行
     *
     * 注意！该插件只用于开发环境，不建议生产环境使用。。。
     */
    @Bean(name = "SqlExplainInterceptor")
    public SqlExplainInterceptor sqlExplainInterceptor(){
        logger.info("sqlExplainInterceptor");
        SqlExplainInterceptor sqlExplainInterceptor=new SqlExplainInterceptor();
        sqlExplainInterceptor.setStopProceed(false);//当其为true时发现全表操作终止之
        return sqlExplainInterceptor;
    }
//    @Bean(name = "myInject")
//    public MySqlInjection mySqlInjection(){
//        logger.info("myInject");
//        return new MySqlInjection();
//    }
//    @Bean("mybatisSqlSession")
//    public SqlSessionFactory sqlSessionFactory(DataSource dataSource, ResourceLoader resourceLoader, GlobalConfiguration globalConfiguration) throws Exception {
//        MybatisSqlSessionFactoryBean sqlSessionFactory = new MybatisSqlSessionFactoryBean();
//        sqlSessionFactory.setDataSource(dataSource);
//        sqlSessionFactory.setTypeAliasesPackage("com.baomidou.mybatisplus.test.h2.entity.persistent");
//        MybatisConfiguration configuration = new MybatisConfiguration();
//        configuration.setDefaultScriptingLanguage(MybatisXMLLanguageDriver.class);
//        configuration.setJdbcTypeForNull(JdbcType.NULL);
//        sqlSessionFactory.setConfiguration(configuration);
//        PaginationInterceptor pagination = new PaginationInterceptor();
//        sqlSessionFactory.setPlugins(new Interceptor[]{
//                pagination,
//                new PerformanceInterceptor(),
//                new OptimisticLockerInterceptor()
//        });
//        sqlSessionFactory.setGlobalConfig(globalConfiguration);
//        return sqlSessionFactory.getObject();
//    }

    @Bean
    public GlobalConfiguration globalConfiguration() {
        GlobalConfiguration conf = new GlobalConfiguration(new LogicSqlInjector());
        conf.setLogicDeleteValue("0");
        conf.setLogicNotDeleteValue("1");
        conf.setIdType(2);


        return conf;
    }

}