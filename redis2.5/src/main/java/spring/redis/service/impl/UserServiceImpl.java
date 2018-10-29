package spring.redis.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.redis.manager.UserManager;
import spring.redis.model.User;
import spring.redis.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserManager userManager;

    @Override
    public List<User> selectTen() {
        Wrapper<User>wrapper=userManager.selectUsers();
        List<User> list=userManager.selectUserList(wrapper,2,10);
        return list;
    }
//
//    @Override
//    public List <User> selectTen2() {
//
//        Page<User> page=new Page <>(1,10);
//        List<User>list=userManager.selectUserPage(page,0).getRecords();
//        return list;
//    }
}
