/*
 * 文件名称：OrderDTO.java
 * 系统名称：[系统名称]
 * 模块名称：[模块名称]
 * 软件版权：Copyright (c) 2011-2018, liming20110711@163.com All Rights Reserved.
 * 功能说明：[请在此处输入功能说明]
 * 开发人员：Rushing0711
 * 创建日期：20180211 23:44
 * 修改记录：
 * <Version>        <DateSerial>        <Author>        <Description>
 * 1.0.0            20180211-01         Rushing0711     M201802112344 新建文件
 ********************************************************************************/
package com.coding.sell.DTO;

import com.coding.sell.DO.OrderDetail;
import com.coding.sell.enums.OrderStatusEnum;
import com.coding.sell.enums.PayStatusEnum;
import com.coding.sell.utils.EnumUtil;
import com.coding.sell.utils.serializer.Date2LongSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * [请在此输入功能简述].
 *
 * <p>创建时间: <font style="color:#00FFFF">20180211 23:44</font><br>
 * [请在此输入功能详述]
 *
 * @author Rushing0711
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
// [lm's ps]: 20180216 10:31 屏蔽在yml的整体JSON转换设置
// @JsonInclude(JsonInclude.Include.ALWAYS)
public class OrderDTO {
    /**
     * 订单id.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180211 21:03</font><br>
     * [请在此输入功能详述]
     *
     * @since 1.0.0
     */
    private String orderId;

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
     * 默认为0-新订单.
     *
     * @since 1.0.0
     */
    private Integer orderStatus;

    /**
     * 支付状态.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180211 21:13</font><br>
     * 默认为0-未支付.
     *
     * @since 1.0.0
     */
    private Integer payStatus;

    /**
     * 创建时间.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180211 21:18</font><br>
     * [请在此输入功能详述]
     *
     * @since 1.0.0
     */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    /**
     * 更新时间.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180211 21:18</font><br>
     * [请在此输入功能详述]
     *
     * @since 1.0.0
     */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    /**
     * 订单明细列表.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180211 23:45</font><br>
     * [请在此输入功能详述]
     *
     * @since 1.0.0
     */
    List<OrderDetail> orderDetailList;

    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum() {
        return EnumUtil.getByCode(orderStatus, OrderStatusEnum.class);
    }

    @JsonIgnore
    public PayStatusEnum getPayStatusEnum() {
        return EnumUtil.getByCode(payStatus, PayStatusEnum.class);
    }
}
