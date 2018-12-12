package spring.redis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HelpController {
    @RequestMapping("/homePage")
    public String getIndex() {
        return "index";
    }
    @RequestMapping("/login")
    public String loginIn(){
        return "login";
    }
    @RequestMapping("/admin")
    public String admin(){
        return "test";
    }

    @RequestMapping("/")
    public String toString() {
        return "index";
    }
}
