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
import spring.redis.manager.UserManager;
import spring.redis.model.User;
import spring.redis.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
}
