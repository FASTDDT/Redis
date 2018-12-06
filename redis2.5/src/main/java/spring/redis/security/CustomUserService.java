package spring.redis.security;

import help.Enum.AuthorityEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import spring.redis.mapper.UserMapper;
import spring.redis.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Discription
 * </p>
 *
 * @author father
 * @ClassName CustomUserService
 * @since 2018/12/6 10:36
 */
@Service
public class CustomUserService implements UserDetailsService { //自定义UserDetailsService 接口

    @Autowired
    UserMapper userMapper;
    public UserDetails loadUserByUsername(String username) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        User user = userMapper.findByUserName(username);
        if (user != null) {
            for (AuthorityEnum e : AuthorityEnum.values()) {
                if (e.getCode().equals(user.getUserRole())) {
                    GrantedAuthority authority = new SimpleGrantedAuthority(e.getDisc());
                    authorities.add(authority);
                }
            }
            return new org.springframework.security.core.userdetails.User(user.getUserNickname(), user.getUserPassword(), authorities);
        } else {
            throw new UsernameNotFoundException(username);
        }


    }

}
