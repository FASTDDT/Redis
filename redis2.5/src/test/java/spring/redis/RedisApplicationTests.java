package spring.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import spring.redis.manager.UserManager;
import spring.redis.model.User;
import spring.redis.service.UserService;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisApplicationTests {
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
    public void page(){
 //      List<User> list=userService.selectTen2();
//        for (User user:list) {
//            System.out.println(user.getUserId());

//        }
    }
    @Test
    public void hasBeans(){
        boolean b = applicationContext.containsBean("Page");
        for (int i = 0; i <10 ; i++) {
            System.out.println(b);

        }
    }
    @Test
    public void helpPage(){
        userManager.helpPage();
    }

}
