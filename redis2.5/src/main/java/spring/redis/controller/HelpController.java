package spring.redis.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.redis.manager.UserManager;

@Controller
@Slf4j
public class HelpController {
    @Autowired
    UserManager userManager;

    @RequestMapping("/homePage")
    public String getIndex() {
        return "index";
    }

    @RequestMapping("/myfault")
    public String fault() {
        return "fault";
    }

    @RequestMapping("/login")
    public String loginIn() {
        return "login";
    }

    @RequestMapping("/admin")
    public String admin() {
        return "test";
    }

    @RequestMapping("/")
    public String toString() {
        log.info("访问/");
        return "index";
    }

    @RequestMapping("/hello")
    public String heloo() {
        return "login_success";
    }

}
