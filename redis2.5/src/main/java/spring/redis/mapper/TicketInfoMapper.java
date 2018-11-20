package spring.redis.mapper;

import spring.redis.model.TestUnion;
import spring.redis.model.TicketInfo;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author father
 * @since 2018-10-29
 */
public interface TicketInfoMapper extends BaseMapper<TicketInfo> {

    List<TestUnion> unionDemo();
}
