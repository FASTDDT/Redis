package help.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 *
 * @author vic
 * @desc redis config bean
 *
 */
@Configuration
@EnableAutoConfiguration
public class RedisConfig {

    private static Logger logger = LoggerFactory.getLogger(RedisConfig.class);
    @Value("${spring.redis.host}")
    private String hostName;
    @Value("${spring.redis.port}")
    private int port;
    @Value("${spring.redis.password}")
    private String password;
    @Value("${redis.timeout}")
    private int timeout;
    public JedisPoolConfig getRedisConfig(){
        JedisPoolConfig config = new JedisPoolConfig();
        return config;
    }

    @Bean(name = "JedisPool")
    public JedisPool getJedisPool(){
        JedisPoolConfig config = getRedisConfig();
        JedisPool pool = new JedisPool(config,hostName,port,timeout,password);
        logger.info("init JedisPool ...");
        return pool;
    }

}