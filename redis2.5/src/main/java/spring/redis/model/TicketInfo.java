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
@TableName("ticket_info")
public class TicketInfo extends Model<TicketInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 票务表主键id
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;
    /**
     * 票务编号id—前5位为场馆编号 6-13 位是年月日 14-15位为场次
     */
    @TableField("ticket_id")
    private String ticketId;
    /**
     * 场次
     */
    @TableField("ticket_times")
    private Integer ticketTimes;
    /**
     * 票务表名称
     */
    @TableField("ticket_name")
    private String ticketName;
    /**
     * 项目id（假外键）
     */
    @TableField("project_id")
    private Integer projectId;
    /**
     * 剩余票数
     */
    private Integer lefts;
    /**
     * 项目参观价格（单位：分）
     */
    private Long price;
    /**
     * 开始时间
     */
    private Date Begintime;
    /**
     * 结束时间
     */
    private Date Overtime;
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
