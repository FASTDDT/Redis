package spring.redis.manager.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.PageHelper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import spring.redis.model.User;
import spring.redis.mapper.UserMapper;
import spring.redis.manager.UserManager;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author father
 * @since 2018-10-29
 */
@Service
public class UserManagerImpl extends ServiceImpl<UserMapper, User> implements UserManager {


    UserMapper userMapper;
    @Override
    public List<User> selectUserList(Wrapper<User> wrapper, Integer current, Integer size) {
        List<User> list=selectPage(new Page <>(current, size),wrapper).getRecords();
        return list;
    }

    @Override
    public Wrapper <User> selectUsers() {
        Wrapper<User> userWrapper=new EntityWrapper <>();
        userWrapper.where("1={0}",1);
        return userWrapper;
    }

    @Override
    public List <User> helpPage() {
        PageHelper.startPage(1, 10);
        List<User> data = selectList(selectUsers());

        for (User user:data)
            System.out.println(user.getUserId());
        // 获取总条数
        Long total = PageHelper.getTotal();
        System.out.println(total);
        // 获取总条数，并释放资源
         total = PageHelper.freeTotal();
        System.out.println(total);
        return data;
    }
//
//    @Override
//    public Page<User> selectUserPage(Page<User> page, Integer version) {
//        // 不进行 count sql 优化，解决 MP 无法自动优化 SQL 问题
//        // page.setOptimizeCountSql(false);
//        // 不查询总记录数
//        // page.setSearchCount(false);
//        // 注意！！ 分页 total 是经过插件自动 回写 到传入 page 对象
//        return page.setRecords(userMapper.selectUserList(page, version));
//    }
//
//    @Override
//    public List <User> selectUserList(Pagination page, Integer state) {
//        return null;
//    }
}
