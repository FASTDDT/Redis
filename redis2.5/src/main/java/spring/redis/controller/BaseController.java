package spring.redis.controller;

import org.springframework.security.core.context.SecurityContextHolder;

/**
 * <p>
 * Discription
 * </p>
 *
 * @author father
 * @ClassName BaseController
 * @since 2018/12/14 19:59
 */

public class BaseController {
    public String getUserId(){
        String username= SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println(username);
        return username;
    }
    public boolean checkOwn(String username){
        return getUserId().equals(username);
    }
}
