/*
 * 文件名称：ResultEnum.java
 * 系统名称：[系统名称]
 * 模块名称：[模块名称]
 * 软件版权：Copyright (c) 2011-2018, liming20110711@163.com All Rights Reserved.
 * 功能说明：[请在此处输入功能说明]
 * 开发人员：Rushing0711
 * 创建日期：20180212 08:09
 * 修改记录：
 * <Version>        <DateSerial>        <Author>        <Description>
 * 1.0.0            20180212-01         Rushing0711     M201802120809 新建文件
 ********************************************************************************/
package com.coding.sell.enums;

import lombok.Getter;

/**
 * [请在此输入功能简述].
 *
 * <p>创建时间: <font style="color:#00FFFF">20180212 08:10</font><br>
 * [请在此输入功能详述]
 *
 * @author Rushing0711
 * @version 1.0.0
 * @since 1.0.0
 */
@Getter
public enum ResultEnum {
    /** 0 - 成功. */
    SUCCESS(0, "成功"),
    /** 1- 参数不正确. */
    PARAM_ERROR(1, "参数不正确"),
    /** 10 - 商品不存在. */
    PRODUCT_NOT_EXIST(10, "商品不存在"),
    /** 11 - 商品库存不正确. */
    PRODUCT_STOCK_ERROR(11, "商品库存不正确"),
    /** 12 - 订单不存在. */
    ORDER_NOT_EXIST(12, "订单不存在"),
    /** 13 - 订单详情不存在. */
    ORDERDETAIL_NOT_EXIST(13, "订单详情不存在"),
    /** 14 - 订单状态不正确. */
    ORDER_STATU_ERROR(14, "订单状态不正确"),
    /** 15 - 订单更新失败. */
    ORDER_UPDATE_FAIL(15, "订单更新失败"),
    /** 16 - 订单详情为空. */
    ORDER_DETAIL_EMPYT(16, "订单详情为空"),
    /** 17 - 订单支付状态不正确. */
    ORDER_PAY_STATUS_ERROR(17, "订单支付状态不正确"),
    /** 18 - 购物车不能为空. */
    CART_EMPTY(18, "购物车不能为空"),
    /** 19 - 该订单不属于当前用户. */
    ORDER_OWNER_ERROR(19, "该订单不属于当前用户"),
    /** 20 - 微信公众账号方面错误. */
    WECHAT_MP_ERROR(20, "微信公众账号方面错误"),
    /** 21 - 微信支付异步通知金额校验不通过. */
    WXPAY_NOTIFY_MONEY_VERIFY_ERROR(21, "微信支付异步通知金额校验不通过"),
    /** 22 - 订单取消成功. */
    ORDER_CANCEL_SUCCESS(22, "订单取消成功"),
    /** 23 - 订单完结成功 */
    ORDER_FINISH_SUCCESS(23, "订单完结成功"),
    /** 24 - 商品状态不正确. */
    PRODUCT_STATUS_ERROR(24, "商品状态不正确"),
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
