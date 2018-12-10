package spring.redis.manager.impl;

import spring.redis.model.SysRole;
import spring.redis.mapper.SysRoleMapper;
import spring.redis.manager.SysRoleManager;
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
public class SysRoleManagerImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleManager {

}
