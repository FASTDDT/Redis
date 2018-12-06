package spring.redis.manager.impl;

import spring.redis.model.Permission;
import spring.redis.mapper.PermissionMapper;
import spring.redis.manager.PermissionManager;
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
public class PermissionManagerImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionManager {

}
