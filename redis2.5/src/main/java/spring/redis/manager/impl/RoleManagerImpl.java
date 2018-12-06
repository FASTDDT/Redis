package spring.redis.manager.impl;

import spring.redis.model.Role;
import spring.redis.mapper.RoleMapper;
import spring.redis.manager.RoleManager;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author father
 * @since 2018-12-06
 */
@Service
public class RoleManagerImpl extends ServiceImpl<RoleMapper, Role> implements RoleManager {

}
