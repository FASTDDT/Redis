package spring.redis.manager;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import spring.redis.model.User;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author father
 * @since 2018-10-29
 */
public interface UserManager extends IService<User> {
    List<User> selectUserList(Wrapper<User> wrapper, Integer current, Integer size);
    Wrapper<User> selectUsers();
//    Page<User> selectUserPage(Page<User> page, Integer version);

    List<User> helpPage();
}
