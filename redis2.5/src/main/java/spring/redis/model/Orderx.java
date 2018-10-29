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
@TableName("orderx")
public class Orderx extends Model<Orderx> {

    private static final long serialVersionUID = 1L;

    /**
     * 订单表主键id
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;
    /**
     * 订单id—前15位为票务号 最后两位为座位号
     */
    @TableField("order_id")
    private String orderId;
    /**
     * 票务编号id（假外键）
     */
    @TableField("ticket_id")
    private Integer ticketId;
    /**
     * 订票数量
     */
    @TableField("order_num")
    private Integer orderNum;
    /**
     * 订单价格
     */
    @TableField("order_price")
    private Long orderPrice;
    /**
     * 用户编号（假外键）
     */
    @TableField("user_id")
    private Long userId;
    /**
     * 支付时返回的账单号
     */
    @TableField("Bill_number")
    private String billNumber;
    /**
     * 订单状态：0待支付 1已支付 2支付失败 3支付未体验 4 退款 5 完成体验
     */
    private Integer state;
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
