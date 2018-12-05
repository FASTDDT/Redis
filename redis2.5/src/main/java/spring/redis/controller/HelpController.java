package spring.redis.controller;

import help.Form.LoginForm;
import help.Vo.UserVo;
import help.common.Result;
import help.util.Internet;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import spring.redis.manager.RedisManager;
import spring.redis.manager.UserManager;
import spring.redis.model.User;
import spring.redis.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/")
public class HelpController {
    @Autowired
    RedisManager redisManager;
    @RequestMapping("/")
    public ModelAndView index(HttpServletRequest request, ModelAndView modelAndView) {
        String s = request.getSession().getId();
        modelAndView.setViewName("index");
        modelAndView.addObject("sessionId", s);
        redisManager.getKeys("*");
        return modelAndView;
    }

}
