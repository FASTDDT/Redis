package help.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.MybatisConfiguration;
import com.baomidou.mybatisplus.MybatisXMLLanguageDriver;
import com.baomidou.mybatisplus.entity.GlobalConfiguration;
import com.baomidou.mybatisplus.mapper.LogicSqlInjector;
import com.baomidou.mybatisplus.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.plugins.PerformanceInterceptor;
import com.baomidou.mybatisplus.plugins.SqlExplainInterceptor;
import com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;


//Spring boot方式
@EnableTransactionManagement
@Configuration
@Slf4j
public class MybatisPlusConfig {
    /**
     * 分页插件
     */
    @Bean(name = "Page")
    public PaginationInterceptor paginationInterceptor() {
            log.info("paginationInterceptor");
        return new PaginationInterceptor();
    }

    /**
     * 乐观锁
     * @return
     */
    @Bean(name = "OptimisticLockerInterceptor")
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        log.info("OptimisticLockerInterceptor");
        return new OptimisticLockerInterceptor();
    }

    /**
     * 性能分析插件
     * @return
     */
    @Bean(name = "performanceInterceptor")
    public PerformanceInterceptor performanceInterceptor() {
        log.info("performanceInterceptor");
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
        log.info("sqlExplainInterceptor");
        SqlExplainInterceptor sqlExplainInterceptor=new SqlExplainInterceptor();
        sqlExplainInterceptor.setStopProceed(false);//当其为true时发现全表操作终止之
        return sqlExplainInterceptor;
    }
//    @Bean(name = "myInject")
//    public MySqlInjection mySqlInjection(){
//        logger.info("myInject");
//        return new MySqlInjection();
//    }
    @Bean
    public DataSource dateSource() {
        DruidDataSource dataSource = new DruidDataSource();

        return dataSource;
    }

    @Bean("mybatisSqlSession")
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource, ResourceLoader resourceLoader, GlobalConfiguration globalConfiguration) throws Exception {
        MybatisSqlSessionFactoryBean sqlSessionFactory = new MybatisSqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);
        sqlSessionFactory.setTypeAliasesPackage("spring.redis.model");
        val r= new PathMatchingResourcePatternResolver();
        sqlSessionFactory.setMapperLocations(r.getResources("classpath:/mapper/*.xml"));
        MybatisConfiguration configuration = new MybatisConfiguration();
        configuration.setDefaultScriptingLanguage(MybatisXMLLanguageDriver.class);
        configuration.setJdbcTypeForNull(JdbcType.NULL);
        sqlSessionFactory.setConfiguration(configuration);
        PaginationInterceptor pagination = new PaginationInterceptor();
        sqlSessionFactory.setPlugins(new Interceptor[]{
                pagination,
                new PerformanceInterceptor(),
                new OptimisticLockerInterceptor()
        });
        sqlSessionFactory.setGlobalConfig(globalConfiguration);
        return sqlSessionFactory.getObject();
    }

    @Bean
    public GlobalConfiguration globalConfiguration() {
        GlobalConfiguration conf = new GlobalConfiguration(new LogicSqlInjector());
        conf.setLogicDeleteValue("0");
        conf.setLogicNotDeleteValue("1");
        conf.setIdType(2);


        return conf;
    }

}