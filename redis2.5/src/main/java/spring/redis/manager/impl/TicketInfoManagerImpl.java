package spring.redis.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import spring.redis.model.TestUnion;
import spring.redis.model.TicketInfo;
import spring.redis.mapper.TicketInfoMapper;
import spring.redis.manager.TicketInfoManager;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author father
 * @since 2018-10-29
 */
@Service
public class TicketInfoManagerImpl extends ServiceImpl<TicketInfoMapper, TicketInfo> implements TicketInfoManager {
    @Autowired
    TicketInfoMapper ticketInfoMapper;
    @Override
    public List<TestUnion> getUnion() {

        return ticketInfoMapper.unionDemo();
    }
}
