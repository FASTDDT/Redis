
package help.Task;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


//
//@Slf4j
//@Component
public class SubscribeThread {
//    @Autowired
//    JedisPool jedisPool;
//
//    @Override
//    public void run(String... strings) throws Exception {
//        Jedis jedis = jedisPool.getResource();
//        try {
//            //监听所有reids通道中的过期事件
//            jedis.psubscribe(new Subscribe(), "*");
//        } catch (Exception e) {
//            jedis.close();
//            e.printStackTrace();
//        } finally {
//            jedis.close();
//        }
//    }
}
