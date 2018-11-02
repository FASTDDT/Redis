package spring.redis.service;

import spring.redis.model.User;

import java.util.List;

public interface UserService {
    List<User> selectTen();

}
