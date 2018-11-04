package spring.redis.controller;

import help.common.Result;
import help.util.Internet;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class HelpController {
    @RequestMapping("/")
    public String index(){

        return "index";
    }
//    @RequestMapping("/errorPage")
//    public String errorPage(){
//        return "error";
//    }
@ResponseBody
@RequestMapping(value = "/getIp")
@ApiOperation(value = "获取主机IP",httpMethod = "POST",notes = "返回操作结果")
public Result<String> getIp(){
    String string= null;
    try {
        string = Internet.getLocalHostLANAddress().getHostAddress();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return Result.getSuccessResult(string);
}

}
