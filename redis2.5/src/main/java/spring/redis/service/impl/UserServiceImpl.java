package spring.redis.service.impl;

import com.baomidou.mybatisplus.mapper.Wrapper;
import help.Form.LoginForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.redis.manager.RedisManager;
import spring.redis.manager.UserManager;
import spring.redis.model.User;
import spring.redis.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    Logger log= LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    UserManager userManager;
    @Autowired
    RedisManager redisManager;
    @Override
    public List<User> selectTen() {
        Wrapper<User>wrapper=userManager.selectUsers();
        List<User> list=userManager.selectUserList(wrapper,2,10);
        return list;
    }

    @Override
    public Boolean Login(LoginForm form,String sessionid) {
        User user=userManager.LoginCheck(form);
        if (user !=null){
            Long userid=user.getUserId();
            redisManager.set(sessionid,userid.toString());
            log.info("sessionid:"+sessionid+"\t"+"userId:"+userid+"登录成功！");
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
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
