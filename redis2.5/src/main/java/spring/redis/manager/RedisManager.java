package spring.redis.service;

import redis.clients.jedis.Jedis;

public interface RedisService {

    Jedis getResource();

    void returnResource(Jedis jedis);

    void set(String key, String value);

    String get(String key);
}
