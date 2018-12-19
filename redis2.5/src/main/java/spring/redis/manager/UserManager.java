package spring.redis.manager;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import help.Form.LoginForm;
import help.Vo.UserVo;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import spring.redis.mapper.UserMapper;
import spring.redis.model.TestUnion;
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


    int count();
    List<User> helpPage();
    String ObjToJson(User user);
    Boolean OptimisticLocker();

    List<User> selectPage();

    Integer updateMoney() throws InterruptedException;

    List<User> selectUserList(Integer current, Integer size);

    User LoginCheck(LoginForm form);

    User getUser(Long userId);
    UserVo creatUserVo(User user);

    List<User> testSelect();

    List<User> testSelectSome();

    //事务

    public boolean addUser(User user);
}
