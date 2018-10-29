package spring.redis.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import spring.redis.manager.OrderxManager;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author father
 * @since 2018-10-29
 */
@Controller
@RequestMapping("/orderx")
public class OrderxController {
    @Autowired
    OrderxManager orderxManager;
}

