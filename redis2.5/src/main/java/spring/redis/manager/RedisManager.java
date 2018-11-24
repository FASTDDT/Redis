package spring.redis.manager;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import spring.redis.model.TicketInfo;

import java.util.Map;
import java.util.Set;

public interface RedisManager {

    Jedis getResource();

    void returnResource(Jedis jedis);

    void set(String key, String value);

    void set(String table, String key, String value);

    void set(String dbname, String table, String key, String value);

    String get(String table, String key);

    String get(String key);

    Boolean exists(String key);

    Set <String> getKeys(String word);

    void flushCache();

    Map<String,String> getHashMap(String key);

    Boolean setHashMap(String key,Map<String,String> map);

    Boolean fieldIncr(String key,String field,Long amount);

    Boolean setExpire(String key,Integer seconds);

    Boolean persist(String key);

    void executePipeline(Pipeline pipeline);








}
