package spring.redis.manager.impl;

import help.util.MapAndEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import spring.redis.manager.RedisManager;
import spring.redis.model.TicketInfo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
class RedisManagerImpl implements RedisManager {

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
        return b;
    }

    @Override
    public Set <String> getKeys(String word) {
        jedis = getResource();
        Set <String> values = jedis.keys(word);
        return values;
    }

    @Override
    public void flushCache() {
        jedis = getResource();
        jedis.flushAll();
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
