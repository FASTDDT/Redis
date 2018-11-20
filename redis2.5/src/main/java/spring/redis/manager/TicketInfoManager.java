package spring.redis.manager;

import spring.redis.model.TestUnion;
import spring.redis.model.TicketInfo;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author father
 * @since 2018-10-29
 */
public interface TicketInfoManager extends IService<TicketInfo> {
    List<TestUnion> getUnion();
}
