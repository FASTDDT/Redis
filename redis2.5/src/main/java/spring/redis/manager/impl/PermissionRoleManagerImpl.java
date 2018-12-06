package spring.redis.manager.impl;

import spring.redis.model.PermissionRole;
import spring.redis.mapper.PermissionRoleMapper;
import spring.redis.manager.PermissionRoleManager;
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
public class PermissionRoleManagerImpl extends ServiceImpl<PermissionRoleMapper, PermissionRole> implements PermissionRoleManager {

}
