package help.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import spring.redis.security.CustomUserService;

import java.util.Collection;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author father
 * @ClassName WebSecurityConfig
 * @since 2018/12/3 22:45
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
    http
            .authorizeRequests()
            .antMatchers("/resources/*").permitAll()
            .antMatchers("/admin/*").hasRole("ADMIN")
            .antMatchers("/db/*").hasAnyRole("ADMIN","DBA")
            .antMatchers("/user/*").hasAnyRole("ADMIN","DBA","USER")
            .and()
            .logout()
            .logoutUrl("/logout")
            .logoutSuccessUrl("/homePage")
            .and()
            .formLogin()
            .loginPage("/login");
        http.csrf().disable();
    }

    @Bean
    UserDetailsService customUserService(){ //注册UserDetailsService 的bean
        return new CustomUserService();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService()); //user Details Service验证

    }

}
