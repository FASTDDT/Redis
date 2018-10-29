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

/**
 * <p>
 * 
 * </p>
 *
 * @author father
 * @since 2018-10-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("comment")
public class Comment extends Model<Comment> {

    private static final long serialVersionUID = 1L;

    /**
     * 评论表主键id
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;
    /**
     * 评论编号
     */
    @TableField("comment_id")
    private Integer commentId;
    /**
     * 用户编号（假外键）
     */
    @TableField("user_id")
    private Long userId;
    /**
     * 项目id（假外键）
     */
    @TableField("project_id")
    private Integer projectId;
    private Integer orderId;
    /**
     * 回复
     */
    private Integer reply;
    /**
     * 评论内容
     */
    private String content;
    /**
     * 赞 数
     */
    @TableField("up_number")
    private Integer upNumber;
    /**
     * 踩 数
     */
    @TableField("down_number")
    private Integer downNumber;
    /**
     * 备注
     */
    private Integer remark;
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


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
