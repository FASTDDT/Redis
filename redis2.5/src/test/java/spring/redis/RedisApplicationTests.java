package spring.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import spring.redis.manager.CommentManager;
import spring.redis.manager.RedisManager;
import spring.redis.manager.UserManager;
import spring.redis.model.User;
import spring.redis.service.UserService;
import help.util.Internet;

import java.net.InetAddress;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisApplicationTests {
    @Autowired
    RedisManager redisManager;
    @Autowired
    CommentManager commentManager;
    @Autowired
    UserService userService;
    @Autowired
    UserManager userManager;
    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void contextLoads() {
    }

    @Test
    public void page() {
        //      List<User> list=userService.selectTen2();
//        for (User user:list) {
//            System.out.println(user.getUserId());

//        }
    }

    @Test
    public void hasBeans() {
        boolean b = applicationContext.containsBean("Page");
        for (int i = 0; i < 10; i++) {
            System.out.println(b);

        }
    }

    @Test
    public void selectPage() {
        List <User> users = userManager.selectPage();
        int i = 0;
        for (User user : users) {
            System.out.println(i++ + "\t" + user.getUserId());
        }
    }

    @Test
    public void OptimisticLocker() {
        userManager.OptimisticLocker();
    }

    @Test
    public void selectPage2() {
        List <User> users = userManager.selectUserList(userManager.selectUsers(), 2, 20);
        for (User user : users)
            System.out.println(user.getUserRealname());
    }

    @Test
    public void Injection() {
        commentManager.deleteAll();

    }

    @Test
    public void Sql() {
        Integer integer = userManager.count();
        for (int i = 0; i < 10; i++) {
            System.out.println(integer);
        }
    }

    @Test
    public void update() {
        Integer d = null;
        try {
            d = userManager.updateMoney();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(d);
        }

    }

    @Test
    public void getKeys() {
//        redisManager.flushCache();
        Set <String> keys = redisManager.getKeys("*");

        if (!keys.isEmpty()) {
            for (String s : keys) {
                System.out.println(s);
            }
        } else {
            System.out.println("no keys exists");
        }
    }

    @Test
    public void getValue() {
        String value = redisManager.get("43783dbf-9316-46f7-842f-30aa8876c612");
        System.out.println(value);
    }

    @Test
    public void getPath() {
        try {
            InetAddress address=Internet.getLocalHostLANAddress();
            System.out.println("HostAddress:"+address.getHostAddress());
            System.out.println("HostName"+address.getHostName());
            System.out.println("getAddress"+address.getAddress());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
