package spring.redis.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import spring.redis.model.User;
import spring.redis.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView getSubwayByID(ModelAndView mv,@PathVariable String id) {
        mv.setViewName("model");
        Map<String,String> map=new HashMap<>();
        map.put("username",id);
        mv.addAllObjects(map);
        return mv;
    }
}