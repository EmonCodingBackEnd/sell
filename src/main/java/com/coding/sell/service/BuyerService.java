/*
 * 文件名称：BuyerService.java
 * 系统名称：[系统名称]
 * 模块名称：[模块名称]
 * 软件版权：Copyright (c) 2011-2018, liming20110711@163.com All Rights Reserved.
 * 功能说明：[请在此处输入功能说明]
 * 开发人员：Rushing0711
 * 创建日期：20180216 11:06
 * 修改记录：
 * <Version>        <DateSerial>        <Author>        <Description>
 * 1.0.0            20180216-01         Rushing0711     M201802161106 新建文件
 ********************************************************************************/
package com.coding.sell.service;

import com.coding.sell.DTO.OrderDTO;

/**
 * 买家.
 *
 * <p>创建时间: <font style="color:#00FFFF">20180216 11:06</font><br>
 * [请在此输入功能详述]
 *
 * @author Rushing0711
 * @version 1.0.0
 * @since 1.0.0
 */
public interface BuyerService {

    /**
     * 查询一个订单.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180216 11:09</font><br>
     * [请在此输入功能详述]
     *
     * @param openid
     * @param orderId
     * @return OrderDTO
     * @author Rushing0711
     * @since 1.0.0
     */
    OrderDTO findOrderOne(String openid, String orderId);

    /**
     * 取消订单.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180216 11:09</font><br>
     * [请在此输入功能详述]
     *
     * @author Rushing0711
     * @version 1.0.0
     * @since 1.0.0
     */
    OrderDTO cancelOrder(String openid, String orderId);
}
