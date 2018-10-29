package spring.redis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"spring.redis.service","spring.redis.manager","spring.redis.mapper","spring.redis.model","spring.redis.controller","config"})
@MapperScan(basePackages = {"spring.redis.mapper"})

@SpringBootApplication
public class RedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisApplication.class, args);
    }
}
