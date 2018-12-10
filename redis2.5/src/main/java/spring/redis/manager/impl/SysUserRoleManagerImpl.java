package spring.redis.manager.impl;

import spring.redis.model.SysUserRole;
import spring.redis.mapper.SysUserRoleMapper;
import spring.redis.manager.SysUserRoleManager;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author father
 * @since 2018-12-10
 */
@Service
public class SysUserRoleManagerImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleManager {

}
