package spring.redis.manager.impl;

import spring.redis.model.Orderx;
import spring.redis.mapper.OrderxMapper;
import spring.redis.manager.OrderxManager;
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
public class OrderxManagerImpl extends ServiceImpl<OrderxMapper, Orderx> implements OrderxManager {

}
