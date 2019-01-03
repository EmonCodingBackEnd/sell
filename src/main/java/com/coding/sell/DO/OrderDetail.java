/*
 * 文件名称：OrderDetail.java
 * 系统名称：[系统名称]
 * 模块名称：[模块名称]
 * 软件版权：Copyright (c) 2011-2018, liming20110711@163.com All Rights Reserved.
 * 功能说明：[请在此处输入功能说明]
 * 开发人员：Rushing0711
 * 创建日期：20180211 21:32
 * 修改记录：
 * <Version>        <DateSerial>        <Author>        <Description>
 * 1.0.0            20180211-01         Rushing0711     M201802112132 新建文件
 ********************************************************************************/
package com.coding.sell.DO;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * [请在此输入功能简述].
 *
 * <p>创建时间: <font style="color:#00FFFF">20180211 21:32</font><br>
 * [请在此输入功能详述]
 *
 * @author Rushing0711
 * @version 1.0.0
 * @since 1.0.0
 */
@Entity
@Data
public class OrderDetail {

    @Id private String detailId;

    /**
     * 订单id.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180211 21:33</font><br>
     * [请在此输入功能详述]
     *
     * @since 1.0.0
     */
    private String orderId;

    /**
     * 商品id.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180211 21:34</font><br>
     * [请在此输入功能详述]
     *
     * @since 1.0.0
     */
    private String productId;

    /**
     * 商品名称.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180211 21:34</font><br>
     * [请在此输入功能详述]
     *
     * @since 1.0.0
     */
    private String productName;

    /**
     * 单价.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180211 21:35</font><br>
     * [请在此输入功能详述]
     *
     * @since 1.0.0
     */
    private BigDecimal productPrice;

    /**
     * 商品数量.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180211 21:36</font><br>
     * [请在此输入功能详述]
     *
     * @since 1.0.0
     */
    private Integer productQuantity;

    /**
     * 商品小图.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180211 21:36</font><br>
     * [请在此输入功能详述]
     *
     * @since 1.0.0
     */
    private String productIcon;
}
