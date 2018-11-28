package spring.redis;


import com.zaxxer.hikari.util.DriverDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

//@Import(DriverDataSource.class)
@ComponentScan(basePackages = {"spring.redis.*","help.*"})
@MapperScan(basePackages = {"spring.redis.mapper"})
@EnableScheduling
@SpringBootApplication
public class RedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisApplication.class, args);
    }
}
