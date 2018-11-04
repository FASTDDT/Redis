package spring.redis.controller;

import help.Form.LoginForm;
import help.common.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import spring.redis.manager.RedisManager;
import help.util.Internet;
import spring.redis.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestController
public class testController {
    @Autowired
    RedisManager redisManager;
    @Autowired
    UserService userService;
    @RequestMapping(value = "/first")
    public Map<String, Object> firstResp (HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        request.getSession().setAttribute("request Url", request.getRequestURL());
        map.put("request Url", request.getRequestURL());
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/sessions")
    @ApiOperation(value = "获取本机ip",httpMethod = "POST",notes = "返回操作结果")
    public Object sessions (HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        String sessionId=request.getSession().getId();
//        System.out.println("request.getSession().getId()"+sessionId);
//        sessionId=request.getRequestedSessionId();
//        System.out.println("request.getRequestedSessionId()"+sessionId);
//        sessionId=request.getSession().toString();
//        System.out.println("request.getSession().toString()"+sessionId);
//
//        redisManager.set(sessionId,"123456789");
//        map.put("sessionId", sessionId);
//        String value;
//        map.put("message", request.getSession().getAttribute("map"));
        Set<String> set=redisManager.getKeys("*");
        if (set.isEmpty()){
            System.out.println("没有session!");
        }else{
            for (String s:set) {
                //value=redisManager.get(s);
                System.out.println(s+"\t");
            }
        }
        return map;
    }


    @ResponseBody
    @RequestMapping(value = "/myIp")
    @ApiOperation(value = "获取本机ip",httpMethod = "POST",notes = "返回操作结果")
    public Result<String> showHotProjects(){
        try {
            String ip= Internet.getLocalHostLANAddress().getHostAddress();
            return Result.getSuccessResult(ip);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @ResponseBody
    @RequestMapping(value = "/flush")
    @ApiOperation(value = "清空redis缓存",httpMethod = "POST",notes = "返回操作结果")
    public Result<String> flushCache(){
        redisManager.flushCache();
        return Result.getSuccessResult("redis已清空");
    }
    @ResponseBody
    @RequestMapping(value = "/getkeys")
    @ApiOperation(value = "清空redis缓存",httpMethod = "POST",notes = "返回操作结果")
    public Result<String> getkeys(){
       Set<String> set=redisManager.getKeys("*");
        if (set.isEmpty()){
            System.out.println("缓存为空！");
        }else {
            for (String s:set
                 ) {
                System.out.println(s);

            }
        }
        return Result.getSuccessResult("redis已清空");
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request,LoginForm form){
        String sessionId=request.getSession().getId();
        Boolean b=userService.Login(form,sessionId);
        if (b.equals(Boolean.TRUE)){
            return "success";
        }else {
            return "login";
        }
    }
}
