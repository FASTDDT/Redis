package help.Aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义切面注解
 */
@Retention(RetentionPolicy.CLASS)//生命注释保留时长，这里无需反射使用，使用CLASS级别
@Target(ElementType.METHOD)//生命可以使用此注解的元素级别类型（如类、方法变量等）
public @interface MyIntercept {
}
