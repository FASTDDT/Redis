package spring.redis.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import spring.redis.model.User;
import spring.redis.service.UserService;

import java.util.List;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author father
 * @since 2018-10-29
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("/test")
    public String start(){
        userService.selectTen();
//        userService.selectTen2();
        return "hello";
    }

    @RequestMapping("/start")
    public String atR(){
//        userService.selectTen();
  //      userService.selectTen2();
        return "hello";
    }
}

/**
 * Error:Maven Resources Compiler: Failed to copy 'E:\springbootTest\springboot2018.2.5\redis2.5\src\main\resources\mapper\UserMapper.xml' to 'E:\springbootTest\springboot2018.2.5\redis2.5\target\classes\mapper\UserMapper.xml': E:\springbootTest\springboot2018.2.5\redis2.5\target\classes\mapper\UserMapper.xml (拒绝访问。)
 */

