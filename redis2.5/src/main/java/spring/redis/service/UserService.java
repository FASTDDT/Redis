package spring.redis.service;

import help.Form.LoginForm;
import help.Vo.UserVo;
import spring.redis.model.User;

import java.util.List;

public interface UserService {
    List<User> selectTen();
    Boolean Login(LoginForm form,String sessionid);
    UserVo getUserVo(Long userId);


}
