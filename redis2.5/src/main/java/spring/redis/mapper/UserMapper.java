package spring.redis.mapper;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import spring.redis.model.SysPermission;
import spring.redis.model.SysRole;
import spring.redis.model.SysRolePermission;
import spring.redis.model.User;

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

    @Select("select * from user where user_nickname="+"#{username}")
    @ResultMap("BaseResultMap")
    User findByUserName(String username);


    /**
     * 通过username查找 user
     * username是唯一的前提
     *
     * @param username
     * @return SysUser
     */
    User findUserByUsername(String username);

    /**
     * 通过用户名 查找·
     * @param username
     * @return List<SysRole>
     */
    List<SysRole> findRolesByUsername(String username);

    /**
     * 通过用户名 查找权限
     * @param username
     * @return List<SysPermission>
     */
    List<SysPermission> findPermissionsByUsername(String username);

    List<SysRolePermission> findAllRolePermissoin();




}
