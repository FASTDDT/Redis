package spring.redis.controller;

import com.alibaba.fastjson.JSON;
import help.Form.LoginForm;
import help.Form.RegistForm;
import help.common.Result;
import io.lettuce.core.dynamic.annotation.Param;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import spring.redis.manager.RedisManager;
import spring.redis.manager.UserManager;
import spring.redis.model.User;
import spring.redis.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/test")
@Slf4j
public class TestController {
    @Autowired
    RedisManager redisManager;
    @Autowired
    UserManager userManager;
    @Autowired
    UserService userService;

    @RequestMapping("")
    public String getTestPage(){
        return "test";
    }

    @RequestMapping("/check")
    public String checkin(){
        return "check";
    }
    @RequestMapping("/register")
    public String regist(@Valid RegistForm form, BindingResult result, HttpServletRequest request) {
        Map <String, String> map = new HashMap <>();
        if (result.hasErrors()) {

            List <FieldError> list = result.getFieldErrors();
            list.forEach((fieldError) -> {
                        map.put(fieldError.getField(), fieldError.getDefaultMessage());
                        System.out.println(fieldError.getField() + "\t" + fieldError.getDefaultMessage());
                    }
            );

            request.setAttribute("map", map);
            request.setAttribute("hi", "......................");
            return "test";
        }
        return "success";
    }

    @RequestMapping("/jedis")
    public String Test() {
        Map <String, String> map = new HashMap <>();
        for (int i = 0; i < 5; i++) {
            map.put("" + i, "" + i);
        }
        System.out.println(redisManager.setHashMap("xxkey", map));
        return "test";

    }
    @ResponseBody
    @RequestMapping("/jsonString")
    @ApiOperation(value = "直接传Json")
    Result<List<String>> Json(){
        List<String> list=new LinkedList <>();
        userManager.testSelect().forEach(user -> list.add(JSON.toJSONString(user)));
        return Result.getSuccessResult(list);
    }

    /**
     * restful test
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public Result<List<User>> getUsers(){
        log.info("RequestMethod.GET");
        List<User> list=userService.selectTen();
        return Result.getSuccessResult(list);
    }
    @ResponseBody
    @RequestMapping(value = "/user/{id}",method = RequestMethod.DELETE)
    public Result<Boolean> delete(@PathVariable String id){
        log.info("RequestMethod.DELETE\t"+id);
        return Result.getSuccessResult(Boolean.TRUE);
    }
    @ResponseBody
    @RequestMapping(value = "/user/{id}",method = RequestMethod.PUT)
    public Result<Boolean> put(@PathVariable("id") String id, @RequestBody LoginForm form){
        log.info("RequestMethod.PUT\tid="+id+"\tusername="+JSON.toJSONString(form));
        return Result.getSuccessResult(Boolean.TRUE);
    }

}