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
@TableName("project")
public class Project extends Model<Project> {

    private static final long serialVersionUID = 1L;

    /**
     * 项目表主键id
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;
    /**
     * 项目id—前2位为场馆号 3-5位为项目号 
     */
    @TableField("project_id")
    private String projectId;
    @TableField("project_name")
    private String projectName;
    /**
     * 项目图片url
     */
    @TableField("project_picture")
    private String projectPicture;
    /**
     * 项目信息
     */
    @TableField("project_info")
    private String projectInfo;
    private Integer experienceTime;
    private Integer restTime;
    /**
     * 最大容纳参观人数
     */
    private Integer capacity;
    /**
     * 项目参观价格（单位：分）
     */
    private Long price;
    /**
     * 场馆id（假外键）
     */
    @TableField("palace_id")
    private Integer palaceId;
    @TableField("total_sold")
    private Integer totalSold;
    /**
     * 备注
     */
    private String remark;
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
