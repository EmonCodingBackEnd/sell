/*
 * 文件名称：OrderStatusEnum.java
 * 系统名称：[系统名称]
 * 模块名称：[模块名称]
 * 软件版权：Copyright (c) 2011-2018, liming20110711@163.com All Rights Reserved.
 * 功能说明：[请在此处输入功能说明]
 * 开发人员：Rushing0711
 * 创建日期：20180211 21:09
 * 修改记录：
 * <Version>        <DateSerial>        <Author>        <Description>
 * 1.0.0            20180211-01         Rushing0711     M201802112109 新建文件
 ********************************************************************************/
package com.coding.sell.enums;

import lombok.Getter;

/**
 * [请在此输入功能简述].
 *
 * <p>创建时间: <font style="color:#00FFFF">20180211 21:10</font><br>
 * [请在此输入功能详述]
 *
 * @author Rushing0711
 * @version 1.0.0
 * @since 1.0.0
 */
@Getter
public enum OrderStatusEnum implements CodeEnum<Integer> {
    /** 0 - 新订单. */
    NEW(0, "新订单"),
    /** 1 - 完结. */
    FINISHED(1, "完结"),
    /** 2 - 已取消. */
    CANCEL(2, "已取消"),
    ;

    private Integer code;

    private String msg;

    OrderStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
