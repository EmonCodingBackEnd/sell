/*
 * 文件名称：ProductStatusEnum.java
 * 系统名称：[系统名称]
 * 模块名称：[模块名称]
 * 软件版权：Copyright (c) 2011-2018, liming20110711@163.com All Rights Reserved.
 * 功能说明：[请在此处输入功能说明]
 * 开发人员：Rushing0711
 * 创建日期：20180210 09:36
 * 修改记录：
 * <Version>        <DateSerial>        <Author>        <Description>
 * 1.0.0            20180210-01         Rushing0711     M201802100936 新建文件
 ********************************************************************************/
package com.coding.sell.enums;

import lombok.Getter;

/**
 * 商品状态.
 *
 * <p>创建时间: <font style="color:#00FFFF">20180210 09:36</font><br>
 * [请在此输入功能详述]
 *
 * @author Rushing0711
 * @version 1.0.0
 * @since 1.0.0
 */
@Getter
public enum ProductStatusEnum implements CodeEnum<Integer> {
    /**
     * 上架.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180407 16:50</font><br>
     * [请在此输入功能详述]
     *
     * @since 1.0.0
     */
    UP(0, "上架"),
    /**
     * 下架.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180407 16:50</font><br>
     * [请在此输入功能详述]
     *
     * @author Rushing0711
     * @version 1.0.0
     * @since 1.0.0
     */
    DOWN(1, "下架");

    private Integer code;

    private String msg;

    ProductStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
