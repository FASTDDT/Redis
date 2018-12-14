package spring.redis.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@Slf4j
public class HelpController {
    @RequestMapping("/homePage")
    public String getIndex() {
      log.info("访问/homePage");
        return "index";
    }
    @RequestMapping("/login")
    public String loginIn(){
        log.info("访问/login");
        return "login";
    }
    @RequestMapping("/admin")
    public String admin(){
        log.info("访问/admin");
        return "test";
    }

    @RequestMapping("/")
    public String toString() {
        log.info("访问/");
        return "index";
    }
    @RequestMapping("/hello")
    public String heloo(){
        return "login_success";
    }
}
