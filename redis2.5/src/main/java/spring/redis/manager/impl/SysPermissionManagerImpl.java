package spring.redis.manager.impl;

import spring.redis.model.SysPermission;
import spring.redis.mapper.SysPermissionMapper;
import spring.redis.manager.SysPermissionManager;
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
public class SysPermissionManagerImpl extends ServiceImpl<SysPermissionMapper, SysPermission> implements SysPermissionManager {

}
