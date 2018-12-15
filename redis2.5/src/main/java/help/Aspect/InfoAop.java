package help.Aspect;

import com.alibaba.fastjson.JSON;
import com.sun.deploy.net.HttpResponse;
import help.util.CheckUser;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.reactive.HttpHandler;
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
 *      aop
 * </p>
 *
 * @author father
 * @ClassName InfoAop
 * @since 2018/12/14 15:04
 */
@Slf4j
//@Aspect
//@Component
public class InfoAop {
    @Autowired
    HttpServletResponse response;
    //定义日志记录器--获取sl4j包下提供的logger
//    ThreadLocal<Long> startTime = new ThreadLocal<>();  //线程副本类去记录各个线程的开始时间


    //定义切入点
	/*1、execution 表达式主体
	  2、第1个* 表示返回值类型  *表示所有类型
	  3、包名  com.*.*.controller下
	  4、第4个* 类名，com.*.*.controller包下所有类
	  5、第5个* 方法名，com.*.*.controller包下所有类所有方法
	  6、(..) 表示方法参数，..表示任何参数
	  */
    @Pointcut("execution(public * spring.*.controller.*.*(..))")
    public void weblog() {

    }

    @Before("weblog()")
    public void dobefore(JoinPoint joinPoint) throws IOException {        //方法里面注入连接点
        log.info("前置通知：");                     //info ,debug ,warn ,erro四种级别，这里我们注入info级别
//        startTime.set(System.currentTimeMillis());

        //获取servlet请求对象---因为这不是控制器，这里不能注入HttpServletRequest，但springMVC本身提供ServletRequestAttributes可以拿到
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        System.out.println(request.getSession().getId());
//        log.info("URL:" + request.getRequestURL().toString());         // 想那个url发的请求
//        log.info("METHOD:" + request.getMethod());
//        log.info("CLASS_METHOD:" + joinPoint.getSignature().getDeclaringTypeName() + "."
//             + joinPoint.getSignature().getName());                     // 请求的是哪个类，哪种方法
//        String s= JSON.toJSONString(joinPoint.getSignature());
//        System.out.println("JSON--->"+s);
        String[] argNames = ((MethodSignature)joinPoint.getSignature()).getParameterNames();
        int i=-1;
        for (String arg:argNames) {
            i++;
            if (arg.equals("username")){
                Object[] o=joinPoint.getArgs();
                System.out.println("哈哈哈"+o[i]);
                boolean b=CheckUser.checkOwn((String) o[i]);
                if (!b){
                    response.sendRedirect("/error");
                }
            }
        }
                throw new AccessDeniedException("权限不足！");

    }


    //方法的返回值注入给ret
    @AfterReturning(returning = "ret", pointcut = "weblog()")
    public void doafter(Object ret) {
        log.info("后置通知：");
        log.info("RESPONSE:" + ret);       // 响应的内容---方法的返回值responseEntity
//        log.info("SPEND:" + ( System.currentTimeMillis()-startTime.get() ));
    }
}
