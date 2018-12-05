package spring.redis.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;

/**
 * <p>
 * SecurityEntity
 * </p>
 *
 * @author father
 * @ClassName User
 * @since 2018/12/5 18:05
 */

public class User implements UserDetails, GrantedAuthority, Serializable {
    private String username;
    private String password;

    public User(String username,String password){
        this.username=username;
        this.password=password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String getAuthority() {
        return null;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<SimpleGrantedAuthority> simpleAuthorities = new ArrayList<>();
////        if(this.role.contains(",")){
////            simpleAuthorities.add(new SimpleGrantedAuthority(this.getAuthority()));
////        }
////        String [] roles=this.getAuthority().split(",");
////        for (String role:roles
////        ) {
////            simpleAuthorities.add(new SimpleGrantedAuthority(role));
////        }
////        return simpleAuthorities;
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
