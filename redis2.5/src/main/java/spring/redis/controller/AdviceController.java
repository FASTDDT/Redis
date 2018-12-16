package spring.redis.controller;

import help.Enum.CodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import java.util.HashMap;
import java.util.List;
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
    private static final String viewname="0error";
    @ExceptionHandler(AccessDeniedException.class)
    public ModelAndView catchAccessDeniedException(AccessDeniedException e){
        return setMv(CodeEnum.NO_AUTHORITY,"map",viewname,e.getMessage());
    }
//   @ExceptionHandler(BadCredentialsException.class)
//    public ModelAndView cachException(BadCredentialsException e){
//        return setMv(CodeEnum.NO_USER,"map","error",e.getMessage());
//    }
    public ModelAndView setMv(CodeEnum codeEnum,String modelName,String viewName){
        Map<String,Object> map=new HashMap<>();
        map.put("code",codeEnum.getCode());
        map.put("disc",codeEnum.getDisc());
        return new ModelAndView(viewName,modelName,map);
    }
    public ModelAndView setMv(CodeEnum codeEnum,String modelName,String viewName,String msg){
        Map<String,Object> map=new HashMap<>();
        map.put("code",codeEnum.getCode());
        map.put("disc",codeEnum.getDisc());
        map.put("msg",msg);
        return new ModelAndView(viewName,modelName,map);
    }
}
