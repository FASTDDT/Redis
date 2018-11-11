package spring.redis.manager;

import redis.clients.jedis.Jedis;

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


}
