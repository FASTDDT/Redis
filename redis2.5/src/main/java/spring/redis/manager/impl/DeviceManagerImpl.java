package spring.redis.manager.impl;

import spring.redis.model.Device;
import spring.redis.mapper.DeviceMapper;
import spring.redis.manager.DeviceManager;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author father
 * @since 2018-10-29
 */
@Service
public class DeviceManagerImpl extends ServiceImpl<DeviceMapper, Device> implements DeviceManager {

}
