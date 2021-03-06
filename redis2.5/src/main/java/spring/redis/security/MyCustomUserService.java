package spring.redis.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.stereotype.Component;
import spring.redis.mapper.UserMapper;
import spring.redis.model.SysRole;
import spring.redis.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Discription
 * </p>
 *
 * @author father
 * @ClassName MyCustomUserService
 * @since 2018/12/10 19:19
 */
@Slf4j
@Component
@Order(1)
public class MyCustomUserService implements UserDetailsService {

    @Autowired
    private SessionRegistry sessionRegistry;
    @Autowired
    private UserMapper sysUserMapper;

    /**
     * 通过验证 将用的所有角色 用户信息中
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info("根据名称获取用户信息： username is {}",username);

        User user = sysUserMapper.findUserByUsername(username);
        if(user==null){
            throw new BadCredentialsException("No user found with username ："+ username);
        }
        List<Object> o = sessionRegistry.getAllPrincipals();
        for ( Object principal : o) {
            if (principal instanceof User && (user.getUserNickname().equals(((User) principal).getUserNickname()))) {
                throw new SessionAuthenticationException("当前用户已经在线，登录失败！！！");
            }
        }

        //获取所有请求的url
        List<SysRole> sysRoles = sysUserMapper.findRolesByUsername(user.getUserNickname());

        log.info("用户角色个数为{}",sysRoles.size());
        log.info("--------------all Roles--------------");
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (SysRole sysRole : sysRoles) {
            //封装用户信息和角色信息 到 SecurityContextHolder全局缓存中
            log.info("name--->{}",sysRole.getName());
            grantedAuthorities.add(new SimpleGrantedAuthority(sysRole.getName()));
        }
        log.info("--------------all Roles--------------");
        return new org.springframework.security.core.userdetails.User(user.getUserNickname(), user.getUserPassword(), grantedAuthorities);
    }
}

