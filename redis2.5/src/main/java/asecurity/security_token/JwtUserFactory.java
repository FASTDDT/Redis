package asecurity.security_token;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import spring.redis.mapper.UserMapper;
import spring.redis.model.SysRole;
import spring.redis.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * Discription
 * </p>
 *
 * @author father
 * @ClassName JwtUserFactory
 * @since 2018/12/15 13:43
 */
public final class JwtUserFactory {
    @Autowired
    private static UserMapper userMapper;
    private JwtUserFactory() {
    }

    public static JwtUser create(User user) {
        return new JwtUser(
                user.getUserId().toString(),
                user.getUserNickname(),
                user.getUserPassword(),
                user.getUserPhone(),
                mapToGrantedAuthorities(userMapper.findRolesByUsername(user.getUserNickname())),
                user.getLastLoginTime()
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<SysRole> authorities) {
        List<String> auth=new ArrayList<>();
        authorities.forEach((a)->auth.add(a.getName()));
        return auth.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}
