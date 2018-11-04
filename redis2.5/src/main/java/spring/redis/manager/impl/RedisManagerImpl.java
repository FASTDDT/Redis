package spring.redis.manager.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import spring.redis.manager.RedisManager;

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
        if(jedis != null){
            jedisPool.returnResourceObject(jedis);
        }
    }

    @Override
    public void set(String key, String value) {
        try{
            jedis = getResource();
            jedis.set(key, value);
            logger.info("Redis set success - " + key + ", value:" + value);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Redis set error: "+ e.getMessage() +" - " + key + ", value:" + value);
        }finally{
            returnResource(jedis);
        }
    }

    @Override
    public void set(String table, String key, String value) {
        set(table+":"+key,value);
    }

    @Override
    public void set(String dbname, String table, String key, String value) {
        set(dbname+":"+table,key,value);
    }

    @Override
    public String get(String table, String key) {
        return get(table+":"+key);
    }

    @Override
    public String get(String key) {
        try{
            jedis = getResource();
            result = jedis.get(key);
            logger.info("Redis get success - " + key + ", value:" + result);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Redis set error: "+ e.getMessage() +" - " + key + ", value:" + result);
        }finally{
            returnResource(jedis);
        }
        return result;
    }

    @Override
    public Set<String> getKeys(String word) {
        jedis=getResource();
        Set<String> values=jedis.keys(word);
        return values;
    }

    @Override
    public void flushCache() {
        jedis=getResource();
        jedis.flushAll();
    }









}
