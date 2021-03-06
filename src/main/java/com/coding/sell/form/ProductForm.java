/*
 * 文件名称：ProductForm.java
 * 系统名称：[系统名称]
 * 模块名称：[模块名称]
 * 软件版权：Copyright (c) 2011-2018, liming20110711@163.com All Rights Reserved.
 * 功能说明：[请在此处输入功能说明]
 * 开发人员：Rushing0711
 * 创建日期：20180221 17:52
 * 修改记录：
 * <Version>        <DateSerial>        <Author>        <Description>
 * 1.0.0            20180221-01         Rushing0711     M201802211752 新建文件
 ********************************************************************************/
package com.coding.sell.form;

import lombok.Data;

import java.math.BigDecimal;

/**
 * [请在此输入功能简述].
 *
 * <p>创建时间: <font style="color:#00FFFF">20180221 17:52</font><br>
 * [请在此输入功能详述]
 *
 * @author Rushing0711
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
public class ProductForm {

    private String productId;

    /**
     * 名字.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180210 09:01</font><br>
     * [请在此输入功能详述]
     *
     * @since 1.0.0
     */
    private String productName;

    /**
     * 单价.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180210 09:02</font><br>
     * [请在此输入功能详述]
     *
     * @since 1.0.0
     */
    private BigDecimal productPrice;

    /**
     * 库存.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180210 09:02</font><br>
     * [请在此输入功能详述]
     *
     * @since 1.0.0
     */
    private Integer productStock;

    /**
     * 描述.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180210 09:03</font><br>
     * [请在此输入功能详述]
     *
     * @since 1.0.0
     */
    private String productDescription;

    /**
     * 小图.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180210 09:03</font><br>
     * [请在此输入功能详述]
     *
     * @since 1.0.0
     */
    private String productIcon;

    /**
     * 类目编号.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180210 09:05</font><br>
     * [请在此输入功能详述]
     *
     * @since 1.0.0
     */
    private Integer categoryType;
}
