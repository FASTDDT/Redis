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
import spring.redis.service.RedisService;
import spring.redis.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/")
public class HelpController {
    @Autowired
    RedisManager redisManager;
    @Autowired
    UserService userService;
    @RequestMapping("/")
    public ModelAndView index(HttpServletRequest request, ModelAndView modelAndView) {
        String s = request.getSession().getId();
        modelAndView.setViewName("index");
//        redisManager.flushCache();
//        redisManager.set(s,null);
        modelAndView.addObject("sessionId", s);
        redisManager.getKeys("*");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "/getIp")
    @ApiOperation(value = "获取主机IP", httpMethod = "POST", notes = "返回操作结果")
    public Result <String> getIp() {
        String string = null;
        try {
            string = Internet.getLocalHostLANAddress().getHostAddress();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.getSuccessResult(string);
    }
    //login_auto

    @ResponseBody
    @RequestMapping(value = "/login_auto")
    @ApiOperation(value = "自动登录", httpMethod = "POST", notes = "返回操作结果")
    public Result <UserVo> login_auto(LoginForm form) {
        String sessionId=form.getSessionId();
        Boolean b=redisManager.exists(sessionId);
        UserVo userVo=null;
        if (b){
            String s=redisManager.get(sessionId);
            Long userId=Long.getLong(s);
            userVo=userService.getUserVo(userId);

        }
        return Result.getSuccessResult(userVo);
    }
    @RequestMapping(value = "/test")
    public String test(HttpServletRequest request){
        try {
            return "test";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "test";
    }

}
