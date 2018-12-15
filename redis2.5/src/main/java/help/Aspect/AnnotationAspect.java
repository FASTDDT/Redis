package help.Aspect;

import help.util.CheckUser;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.util.Arrays;

/**
 * <p>
 * Discription
 * </p>
 *
 * @author father
 * @ClassName AnnotationAspect
 * @since 2018/12/15 9:22
 */
@Component
@Aspect//将当前类标注成一个切面。
@Slf4j
public class AnnotationAspect {
    @Autowired
    HttpServletResponse response;

    @Before("@annotation(MyIntercept)")
    public void dobefore(JoinPoint joinPoint) throws IOException {        //方法里面注入连接点
        String[] argNames = ((MethodSignature) joinPoint.getSignature()).getParameterNames();
        int i = -1;
        for (String arg : argNames) {
            i++;
            if (arg.equals("username")) {
                Object[] o = joinPoint.getArgs();
                String username = CheckUser.getUserId();
                if (!username.equals((String) o[i])) {
                    //获取servlet请求对象---因为这不是控制器，这里不能注入HttpServletRequest，但springMVC本身提供ServletRequestAttributes可以拿到
                    ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
                    HttpServletRequest request = attributes.getRequest();
                    throw new AccessDeniedException(username, request.getRequestURL().toString(), "权限不足！");

                }
            }
        }
    }
}
