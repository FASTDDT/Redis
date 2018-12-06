package spring.redis.security;

import help.Enum.AuthorityEnum;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * Discription
 * </p>
 *
 * @author father
 * @ClassName MyInvocationSecurityMetadataSourceService
 * @since 2018/12/6 18:43
 */
public class MyInvocationSecurityMetadataSourceService implements FilterInvocationSecurityMetadataSource {
    private HashMap<String, Collection<ConfigAttribute>> map =null;

    /**
     * 加载权限表中所有权限
     */
    public void loadResourceDefine(){
        map = new HashMap<>();
        Collection<ConfigAttribute> array;
        ConfigAttribute cfg;

        for(AuthorityEnum e : AuthorityEnum.values()) {
//            array = new ArrayList<>();
//            cfg = new SecurityConfig(e.getDisc());
//            //此处只添加了用户的名字，其实还可以添加更多权限的信息，例如请求方法到ConfigAttribute的集合中去。此处添加的信息将会作为MyAccessDecisionManager类的decide的第三个参数。
//            array.add(cfg);
//            //用权限的getUrl() 作为map的key，用ConfigAttribute的集合作为 value，
//            map.put(permission.getUrl(), array);
        }

    }
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
