package spring.redis.manager.impl;

import help.Task.Subscribe;
import help.util.MapAndEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Pipeline;
import spring.redis.manager.RedisManager;
import spring.redis.model.TicketInfo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
@Service
class RedisManagerImpl implements RedisManager, CommandLineRunner {

    private static Logger logger = LoggerFactory.getLogger(RedisManagerImpl.class);

    @Autowired
    private JedisPool jedisPool;

    private Jedis jedis;

    String result;

    @Override
    public Jedis getResource() {
        return jedisPool.getResource();
    }

    @SuppressWarnings("deprecation")
    @Override
    public void returnResource(Jedis jedis) {
        if (jedis != null) {
            jedisPool.returnResourceObject(jedis);
        }
    }

    @Override
    public void set(String key, String value) {
        try {
            jedis = getResource();
            jedis.set(key, value);
            logger.info("Redis set success - " + key + ", value:" + value);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Redis set error: " + e.getMessage() + " - " + key + ", value:" + value);
        } finally {
            returnResource(jedis);
        }
    }

    @Override
    public void set(String table, String key, String value) {
        set(table + ":" + key, value);

    }

    @Override
    public void set(String dbname, String table, String key, String value) {
        set(dbname + ":" + table, key, value);
    }

    @Override
    public String get(String table, String key) {
        return get(table + ":" + key);
    }

    @Override
    public String get(String key) {
        try {
            jedis = getResource();
            result = jedis.get(key);
            logger.info("Redis get success - " + key + ", value:" + result);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Redis set error: " + e.getMessage() + " - " + key + ", value:" + result);
        } finally {
            returnResource(jedis);

        }
        return result;
    }

    @Override
    public Boolean exists(String key) {
        jedis = getResource();

        Boolean b = jedis.exists(key);
        returnResource(jedis);
        return b;
    }

    @Override
    public Set <String> getKeys(String word) {
        jedis = getResource();
        Set <String> values = jedis.keys(word);
        returnResource(jedis);
        return values;
    }

    @Override
    public void flushCache() {
        jedis = getResource();
        jedis.flushAll();
        returnResource(jedis);

    }

    @Override
    public Map <String, String> getHashMap(String key) {
        jedis=getResource();
        Map<String,String> map=jedis.hgetAll(key);
        returnResource(jedis);
        return map;
    }

    @Override
    public Boolean setHashMap(String key, Map <String, String> map) {
        jedis=getResource();
        Boolean b=jedis.hmset(key,map).equals("OK");
        returnResource(jedis);
        return b;
    }

    @Override
    public Boolean fieldIncr(String key, String field, Long amount) {
        jedis=getResource();
        Long k=jedis.hincrBy(key,field,amount);
        returnResource(jedis);
        return k>=0;
    }

    @Override
    public Boolean setExpire(String key, Integer seconds) {
        jedis=getResource();
        Long k=jedis.expire(key,seconds);
            returnResource(jedis);
        return k==1L;
    }

    @Override
    public Boolean persist(String key) {
        jedis=getResource();
        Long k=jedis.persist(key);
        returnResource(jedis);
        return k==1L;
    }

    @Override
    public void executePipeline(Pipeline pipeline) {
        jedis=getResource();
        pipeline.sync();
        returnResource(jedis);
    }

    @Override
    public void run(String... args) throws Exception {
        Jedis jedis = getResource();
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


//    @Override
//    public String hmset(TicketInfo ticketInfo) {
//        jedis = getResource();
//        Map <String, Object> map = MapAndEntity.objectToMap(ticketInfo);
//
//        return jedis.hmset("hm", map);
//    }
//
//    @Override
//    public Map <String, Object> setTicket(TicketInfo ticketInfo) {
//        Map <String, Object> map = MapAndEntity.objectToMap(ticketInfo);
//        Object key=map.get("id");
//        map.remove("remark");
//        map.remove("is_deleted");
//        map.remove("gmt_create");
//        map.remove("gmt_modify");
//        return map;
//    }


}
