package spring.redis.mapper;

import help.Enum.DeleteEnum;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import spring.redis.model.PermissionRole;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author father
 * @since 2018-12-06
 */
public interface PermissionRoleMapper extends BaseMapper<PermissionRole> {
    @Select("select permission_id from permission_role where role_id="+"#{roleId} and is_deleted=0")
    List<Integer> selectPermissinByRoleId(@Param("roleId") Integer roleId);
    @Select("select  permission.url from role,permission,permission_role where role.id=permission_role.role_id AND permission_role.permission_id=permission.id AND role.id="+"#{roleId} and is_deleted=0")
    List<String> selectUrlByRoleId(@Param("roleId") Integer roleId);
}
