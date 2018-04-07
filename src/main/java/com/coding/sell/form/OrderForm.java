/*
 * 文件名称：OrderForm.java
 * 系统名称：[系统名称]
 * 模块名称：[模块名称]
 * 软件版权：Copyright (c) 2011-2018, liming20110711@163.com All Rights Reserved.
 * 功能说明：[请在此处输入功能说明]
 * 开发人员：Rushing0711
 * 创建日期：20180213 15:53
 * 修改记录：
 * <Version>        <DateSerial>        <Author>        <Description>
 * 1.0.0            20180213-01         Rushing0711     M201802131553 新建文件
 ********************************************************************************/
package com.coding.sell.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class OrderForm {

    /** 
     * 买家姓名.
     * 
     * <p>创建时间: <font style="color:#00FFFF">20180213 16:36</font><br>
     * [请在此输入功能详述]
     * 
     * @since 1.0.0
     */
    @NotEmpty(message = "姓名必填")
    private String name;

    /**
     * 买家手机号.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180213 15:59</font><br>
     * [请在此输入功能详述]
     *
     * @since 1.0.0
     */
    @NotEmpty(message = "手机号必填")
    private String phone;

    /**
     * 买家地址.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180213 16:37</font><br>
     * [请在此输入功能详述]
     *
     * @since 1.0.0
     */
    @NotEmpty(message = "地址必填")
    private String address;

    /**
     * 买家微信openid.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180213 16:38</font><br>
     * [请在此输入功能详述]
     *
     * @since 1.0.0
     */
    @NotEmpty(message = "openid必填")
    private String openid;

    /**
     * 购物车.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180213 16:38</font><br>
     * [请在此输入功能详述]
     *
     * @since 1.0.0
     */
    @NotEmpty(message = "购物车必填")
    private String items;
}

