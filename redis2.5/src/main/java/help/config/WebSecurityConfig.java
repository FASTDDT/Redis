package help.config;

import help.util.MD5;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import spring.redis.security.MyCustomUserService;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author father
 * @ClassName WebSecurityConfig
 * @since 2018/12/3 22:45
 */
@Slf4j
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 通过 实现UserDetailService 来进行验证
     */
    @Autowired
    private MyCustomUserService myCustomUserService;

    /**
     * @param auth
     * @throws Exception
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        //校验用户
        auth.userDetailsService(myCustomUserService)
                //校验密码
                .passwordEncoder(new PasswordEncoder() {

                    @Override
                    public String encode(CharSequence rawPassword) {
                        try {
                            return MD5.finalMD5(String.valueOf(rawPassword));
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        } catch (NoSuchAlgorithmException e) {
                            e.printStackTrace();
                        }
                        return null;
                    }

                    @Override
                    public boolean matches(CharSequence rawPassword, String encodedPassword) {
                        //return encodedPassword.equals(Md5Util.MD5(String.valueOf(rawPassword)));
                        return encodedPassword.equals(String.valueOf(rawPassword));
                    }
                });

    }


    /**
     * 创建自定义的表单
     * <p>
     * 页面、登录请求、跳转页面等
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/","index","/login","/css/**","/js/**","/img/**")//允许访问
                .permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")//拦截后get请求跳转的页面
                .defaultSuccessUrl("/hello")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

}