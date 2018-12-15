package spring.redis.controller;


import help.Aspect.MyIntercept;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * restful security测试
 * </p>
 *
 * @author father
 * @since 2018-10-29
 */

@Controller
@RequestMapping("/user")
public class UserController {
    @MyIntercept
    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public ModelAndView getSubwayByID(ModelAndView mv, @PathVariable String username) {
        mv.setViewName("model");
        Map<String, String> map = new HashMap<>();
        mv.addAllObjects(map);
        map.put("username", username);
        mv.addAllObjects(map);
        System.out.println("hi,my name is"+username);
        return mv;
    }
}