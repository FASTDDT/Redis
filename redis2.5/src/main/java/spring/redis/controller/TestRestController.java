package spring.redis.controller;

import help.Form.LoginForm;
import help.common.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import spring.redis.manager.RedisManager;
import spring.redis.model.User;
import spring.redis.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestController
public class TestRestController {
    @Autowired
    RedisManager redisManager;
    @Autowired
    UserService userService;

    @RequestMapping(value = "/first")
    public Map <String, Object> firstResp(HttpServletRequest request) {
        Map <String, Object> map = new HashMap <>();
        request.getSession().setAttribute("request Url", request.getRequestURL());
        map.put("request Url", request.getRequestURL());
        return map;
    }


    @ResponseBody
    @RequestMapping(value = "/sessions")
    @ApiOperation(value = "获取本机ip", notes = "返回操作结果")
    public Object sessions(HttpServletRequest request) {
        Map <String, Object> map = new HashMap <>();
        String sessionId = request.getSession().getId();
        Set <String> set = redisManager.getKeys("*");
        if (set.isEmpty()) {
            System.out.println("没有session!");
        } else {
            for (String s : set) {
                //value=redisManager.get(s);
                System.out.println(s + "\t");
            }
        }
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/flush")
    @ApiOperation(value = "清空redis缓存", notes = "返回操作结果")
    public Result <String> flushCache() {
        redisManager.flushCache();
        return Result.getSuccessResult("redis已清空");
    }

    @ResponseBody
    @RequestMapping(value = "/getkeys")
    @ApiOperation(value = "清空redis缓存", notes = "返回操作结果")
    public Result <String> getkeys() {
        Set <String> set = redisManager.getKeys("*");
        if (set.isEmpty()) {
            System.out.println("缓存为空！");
        } else {
            for (String s : set
            ) {
                System.out.println(s);

            }
        }
        return Result.getSuccessResult("redis已清空");
    }

    @ApiOperation(value = "djjjjjjjjjj")
    @RequestMapping(value = "/testswagger", method = RequestMethod.GET)
    public ModelAndView toAddPage(ModelAndView mView) {
        mView.addObject("employee", new User());
        mView.setViewName("index");
        mView.addObject("departments", userService.selectTen());
        return mView;
    }

    @RequestMapping(value = "/login")
    @ApiOperation(value = "自动登录" , notes = "返回操作结果")
    public Map <String, String> login(LoginForm form, HttpServletRequest request) {
        Map <String, String> map = new HashMap <>();
        String s = request.getSession().getId();

        userService.Login(form, s);
        map.put(s, form.getNickName());
        return map;
    }


}
