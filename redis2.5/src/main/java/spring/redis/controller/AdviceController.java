package spring.redis.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author father
 * @since 2018-10-29
 */
@Slf4j
@ControllerAdvice
public class AdviceController {
    @ExceptionHandler
//    @ResponseBody
    public ModelAndView getExceptions(Exception e){
        ModelAndView mv=new ModelAndView();
        Map<String,Integer>map=new HashMap<>();
        if (e instanceof AccessDeniedException) {
            AccessDeniedException le= (AccessDeniedException) e;
            map.put("code",1);
        }else {
            e.printStackTrace();
        }
        mv.setViewName("error");
        mv.addAllObjects(map);

        return mv;
    }
}

