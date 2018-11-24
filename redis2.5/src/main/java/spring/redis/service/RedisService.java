package spring.redis.service;

import java.util.List;
import java.util.Map;

public interface RedisService {

    List<Map<String,String>> getUserOrder(String userid);



}
