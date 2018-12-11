package spring.redis.security;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import spring.redis.mapper.UserMapper;
import spring.redis.model.SysPermission;
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
        log.info("First===============================================测试的JSON:"+JSON.toJSONString(user));
        if(user == null)
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        log.info("Second===============================================测试的JSON:"+JSON.toJSONString(user));
        //获取所有请求的url
        //List<SysPermission> sysPermissions = sysUserMapper.findPermissionsByUsername(user.getUsername());
        List<SysPermission> sysRoles = sysUserMapper.findPermissionsByUsername(username);

        log.info("用户角色个数为{}",sysRoles.size());
        log.info("--------------all Roles--------------");
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (SysPermission permission: sysRoles) {
            //封装用户信息和角色信息 到 SecurityContextHolder全局缓存中
            log.info("name--->{}",permission.getName());
            grantedAuthorities.add(new SimpleGrantedAuthority(permission.getName()));
        }
        log.info("--------------all Roles--------------");
        return new org.springframework.security.core.userdetails.User(user.getUserNickname(), user.getUserPassword(), grantedAuthorities);
    }
}

