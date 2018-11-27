package spring.redis.manager.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.PageHelper;
import help.Enum.DeleteEnum;
import help.Form.LoginForm;
import help.Vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import spring.redis.model.TestUnion;
import spring.redis.model.User;
import spring.redis.mapper.UserMapper;
import spring.redis.manager.UserManager;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import springfox.documentation.spring.web.json.Json;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.Timer;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author father
 * @since 2018-10-29
 */
@Service
public class UserManagerImpl extends ServiceImpl<UserMapper, User> implements UserManager{
    @Autowired
    UserMapper userMapper;
    Random r=new Random();
    Timer timer=new Timer();
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
    public int count() {
        LocalDateTime now=LocalDateTime.now();

        int buyCount = selectCount(Condition.create()
                .setSqlSelect("count(*)")
                .eq("user_sex", 1)
                .in("is_deleted", new Integer[]{0, 1})
                .ge("user_money",999)
                .between("gmt_create",now.minusMonths(6),now));
        return buyCount;
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

    @Override
    public String ObjToJson(User user) {
        String json= JSON.toJSONString(user);
        User user1=JSON.parseObject(json,User.class);
        System.out.println(user1.getUserNickname());
        return json;
    }



    @Override
    public Boolean OptimisticLocker() {
        Long id = 2013122879L;
        int version = 0;

        User u = new User();
        u.setUserId(id);
        u.setVersion(version);
        u.setUserNickname("xxx");
        boolean b=updateById(u);
        if(b){
            System.out.println("Update successfully");
        }else{
            System.out.println("Update failed due to modified by others");
        }
        return b;
    }

    @Override
    public List <User> selectPage() {
        Wrapper<User> userWrapper=new EntityWrapper <>();
        userWrapper.where("1={0}",1)
                .eq("version", 0);
        Page<User> page=new Page <>(2,20);
        List<User> users=selectPage(page,userWrapper).getRecords();

        return users;
    }

    @Override
    public Integer updateMoney() throws InterruptedException {
            Integer integer=0;

//        Integer integer=(Integer)selectObj(Condition.create()
//                .setSqlSelect("Count(*)"));
        Wrapper<User> userWrapper=new EntityWrapper <>();
        userWrapper.where("1={0}",1);
        List<User>list=selectList(userWrapper);
        for (User user:list) {
            Thread.sleep(10000);
            user.setUserMoney(r.nextLong());
            if (updateById(user))
                integer++;


        }
        return integer;
    }

    @Override
    public List <User> selectUserList(Integer current, Integer size) {
        Page<User>userPage=selectPage(new Page <>(2,20),
                new EntityWrapper <User>()
                .eq("version",0));
        return userPage.getRecords();
    }

    @Override
    public User LoginCheck(LoginForm form) {
        String nickname=form.getNickName();
        String pwd=form.getPassword();
        Wrapper<User> wrapper=new EntityWrapper <>();
        wrapper.where("1={0}",1)
                .eq("user_id",nickname)
                .eq("user_password",pwd)
                .eq("is_deleted", DeleteEnum.NOT_DELETE.getCode());
        if (wrapper!=null){
            return selectOne(wrapper);
        }

        return null;
    }

    @Override
    public User getUser(Long userId) {

        return selectById(userId);
    }

    @Override
    public UserVo creatUserVo(User user) {
        UserVo userVo=new UserVo();
        userVo.setNickname(user.getUserNickname());
        return userVo;
    }

    @Override
    public List <User> testSelect() {
        List<User> wrapper=userMapper.getUserList();
        return wrapper;
    }

    @Override
    public List <User> testSelectSome() {
        List<User> users=userMapper.getSome();
        return users;
    }


}
