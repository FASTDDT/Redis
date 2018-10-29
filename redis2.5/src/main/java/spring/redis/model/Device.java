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
@TableName("device")
public class Device extends Model<Device> {

    private static final long serialVersionUID = 1L;

    /**
     * 设备表主键id
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;
    /**
     * 设备名称
     */
    @TableField("device_name")
    private String deviceName;
    @TableField("palace_Id")
    private Integer palaceId;
    @TableField("device_img")
    private String deviceImg;
    /**
     * 设备价格（单位分）
     */
    @TableField("device_price")
    private Long devicePrice;
    /**
     * 设备信息
     */
    @TableField("device_info")
    private String deviceInfo;
    /**
     * 设备状态：0正常 1损坏待维修 2维修中 3报废
     */
    @TableField("device_status")
    private Integer deviceStatus;
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
