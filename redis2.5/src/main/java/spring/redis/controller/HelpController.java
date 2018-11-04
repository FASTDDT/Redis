package spring.redis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.spring.web.json.Json;

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
}
