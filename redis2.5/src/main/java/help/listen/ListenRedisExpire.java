package help.listen;

import help.Task.Subscribe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import spring.redis.manager.RedisManager;

/**
 * <p>
 * Discription
 * </p>
 *
 * @author father
 * @ClassName ListenRedisExpire
 * @since 2018/12/12 19:45
 */
@Service
public class ListenRedisExpire implements CommandLineRunner {
    @Autowired
    RedisManager redisManager;
    @Override
    public void run(String... args) throws Exception {
        Jedis jedis = redisManager.getResource();
        try {
            //监听所有reids通道中的过期事件
            jedis.psubscribe(new Subscribe(), "*");
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            jedis.close();
        }
    }
}
