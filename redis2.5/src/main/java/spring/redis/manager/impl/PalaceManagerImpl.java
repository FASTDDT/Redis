package spring.redis.manager.impl;

import spring.redis.model.Palace;
import spring.redis.mapper.PalaceMapper;
import spring.redis.manager.PalaceManager;
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
public class PalaceManagerImpl extends ServiceImpl<PalaceMapper, Palace> implements PalaceManager {

}
