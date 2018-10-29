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
@TableName("palace")
public class Palace extends Model<Palace> {

    private static final long serialVersionUID = 1L;

    /**
     * 场馆表主键id
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;
    /**
     * 场馆id
     */
    @TableField("palace_id")
    private String palaceId;
    /**
     * 场馆名称
     */
    @TableField("place_name")
    private String placeName;
    /**
     * 场馆展示图片的url
     */
    private String picture;
    /**
     * 场馆介绍信息
     */
    private String info;
    /**
     * 场馆所在地
     */
    private String adress;
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
