package spring.redis.controller;

import com.alibaba.fastjson.JSON;
import help.Form.RegistForm;
import help.common.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import spring.redis.manager.RedisManager;
import spring.redis.manager.UserManager;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Controller
public class TestController {
    @Autowired
    RedisManager redisManager;
    @Autowired
    UserManager userManager;
    @RequestMapping("/register")
    public String regist(@Valid RegistForm form, BindingResult result, HttpServletRequest request) {
//        Map<String,Object>map=result.getModel();
//        map.forEach((k,v)-> System.out.println("regist:"+k+"\t"+v));
////        request.setAttribute("hi",);
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
//        Map <String, String> getMap = redisManager.getHashMap("xxkey");
//        getMap.forEach((key, value) -> System.out.println(key + "\t" + value));
//        map.clear();
//        for (int i = 10; i < 25; i++) {
//            map.put("" + i, "" + i);
//        }
//        System.out.println("==========================================");
//        redisManager.getHashMap("xxkey").forEach((key, value) -> System.out.println(key + "\t" + value));
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
}