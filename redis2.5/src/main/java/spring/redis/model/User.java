package spring.redis.model;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.Version;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author father
 * @since 2018-10-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("user")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;
    @Version
    private Integer version;
    /**
     * 用户编号
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;
    /**
     * 用户昵称
     */
    @NotNull(message = "写个昵称吧！")
    @TableField("user_nickname")
    private String userNickname;
    /**
     * 用户姓名
     */
    @TableField("user_realname")
    private String userRealname;
    /**
     * 用户账号
     */
    @TableField("user_account")
    private String userAccount;
    /**
     * 用户密码
     */
    @TableField("user_password")
    private String userPassword;
    /**
     * 用户性别 0男 1女
     */
    @TableField("user_sex")
    private Integer userSex;
    /**
     * 用户电话
     */

    @TableField("user_phone")
    private String userPhone;
    /**
     * 用户积分 可用于兑换
     */
    @TableField("user_point")
    private Integer userPoint;
    /**
     * 用户余额 可购买教学资料
     */
    @TableField("user_money")
    private Long userMoney;
    /**
     * 用户类型 1学员 2教师 3管理员
     */
    @TableField("user_role")
    private Integer userRole;
    /**
     * 逻辑删除 0未删除 1已删除
     */
    @TableField("is_deleted")
    private Integer isDeleted;
    /**
     * 创建时间
     */
    @TableField("gmt_create")
    private Date gmtCreate;
    /**
     * 修改时间
     */
    @TableField("gmt_modify")
    private Date gmtModify;
    /**
     * 登录状态 0未登录 1登录中
     */
    @TableField("login_status")
    private Integer loginStatus;
    /**
     * 上次登录时间
     */
    @TableField("last_login_time")
    private Date lastLoginTime;


    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

}
