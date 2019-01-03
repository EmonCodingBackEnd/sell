/*
 * 文件名称：CartDTO.java
 * 系统名称：[系统名称]
 * 模块名称：[模块名称]
 * 软件版权：Copyright (c) 2011-2018, liming20110711@163.com All Rights Reserved.
 * 功能说明：[请在此处输入功能说明]
 * 开发人员：Rushing0711
 * 创建日期：20180212 22:35
 * 修改记录：
 * <Version>        <DateSerial>        <Author>        <Description>
 * 1.0.0            20180212-01         Rushing0711     M201802122235 新建文件
 ********************************************************************************/
package com.coding.sell.DTO;

import lombok.Data;

/**
 * 购物车.
 *
 * <p>创建时间: <font style="color:#00FFFF">20180212 22:36</font><br>
 * [请在此输入功能详述]
 *
 * @author Rushing0711
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
public class CartDTO {

    /**
     * 商品Id.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180212 22:36</font><br>
     * [请在此输入功能详述]
     *
     * @since 1.0.0
     */
    private String productId;

    /**
     * 数量.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180212 22:37</font><br>
     * [请在此输入功能详述]
     *
     * @author Rushing0711
     * @version 1.0.0
     * @since 1.0.0
     */
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
