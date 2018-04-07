/*
 * 文件名称：OrderMaster.java
 * 系统名称：[系统名称]
 * 模块名称：[模块名称]
 * 软件版权：Copyright (c) 2011-2018, liming20110711@163.com All Rights Reserved.
 * 功能说明：[请在此处输入功能说明]
 * 开发人员：Rushing0711
 * 创建日期：20180211 21:01
 * 修改记录：
 * <Version>        <DateSerial>        <Author>        <Description>
 * 1.0.0            20180211-01         Rushing0711     M201802112101 新建文件
 ********************************************************************************/
package com.coding.sell.DO;

import com.coding.sell.enums.OrderStatusEnum;
import com.coding.sell.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单主信息.
 *
 * <p>创建时间: <font style="color:#00FFFF">20180211 21:01</font><br>
 * [请在此输入功能详述]
 *
 * @author Rushing0711
 * @version 1.0.0
 * @since 1.0.0
 */
@Entity
@Data
@DynamicUpdate
public class OrderMaster {

    /**
     * 订单id.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180211 21:03</font><br>
     * [请在此输入功能详述]
     *
     * @since 1.0.0
     */
    @Id private String orderId;

    /**
     * 买家名字.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180211 21:06</font><br>
     * [请在此输入功能详述]
     *
     * @since 1.0.0
     */
    private String buyerName;

    /**
     * 买家手机号.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180211 21:06</font><br>
     * [请在此输入功能详述]
     *
     * @since 1.0.0
     */
    private String buyerPhone;

    /**
     * 买家地址.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180211 21:07</font><br>
     * [请在此输入功能详述]
     *
     * @since 1.0.0
     */
    private String buyerAddress;

    /**
     * 买家微信Openid.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180211 21:07</font><br>
     * [请在此输入功能详述]
     *
     * @since 1.0.0
     */
    private String buyerOpenid;

    /**
     * 订单金额.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180211 21:08</font><br>
     * [请在此输入功能详述]
     *
     * @since 1.0.0
     */
    private BigDecimal orderAmount;

    /**
     * 订单状态.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180211 21:09</font><br>
     * {@linkplain OrderStatusEnum#NEW 默认状态}.
     *
     * @since 1.0.0
     */
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    /**
     * 支付状态.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180211 21:13</font><br>
     * {@linkplain PayStatusEnum#WAIT 默认状态}.
     *
     * @since 1.0.0
     */
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    /**
     * 创建时间.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180211 21:18</font><br>
     * [请在此输入功能详述]
     *
     * @since 1.0.0
     */
    private Date createTime;

    /**
     * 更新时间.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180211 21:18</font><br>
     * [请在此输入功能详述]
     *
     * @since 1.0.0
     */
    private Date updateTime;
}
