package spring.redis.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.Version;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class TestUnion implements Serializable {
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

    private Project project;

}
