package spring.redis.mapper;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.redis.model.TestUnion;
import spring.redis.model.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author father
 * @since 2018-10-29
 */
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from user")
    @ResultMap("BaseResultMap")
    List<User> getUserList();


    @Select("select user_id,version from user")
    @ResultMap("BaseResultMap")
    List<User> getSome();


}
