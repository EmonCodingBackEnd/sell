/*
 * 文件名称：SellerService.java
 * 系统名称：[系统名称]
 * 模块名称：[模块名称]
 * 软件版权：Copyright (c) 2011-2018, liming20110711@163.com All Rights Reserved.
 * 功能说明：[请在此处输入功能说明]
 * 开发人员：Rushing0711
 * 创建日期：20180221 23:12
 * 修改记录：
 * <Version>        <DateSerial>        <Author>        <Description>
 * 1.0.0            20180221-01         Rushing0711     M201802212312 新建文件
 ********************************************************************************/
package com.coding.sell.service;

import com.coding.sell.DO.SellerInfo;

/**
 * [请在此输入功能简述].
 *
 * <p>创建时间: <font style="color:#00FFFF">20180221 23:12</font><br>
 * [请在此输入功能详述]
 *
 * @author Rushing0711
 * @version 1.0.0
 * @since 1.0.0
 */
public interface SellerService {

    /**
     * 通过openid查询卖家端信息.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180221 23:14</font><br>
     * [请在此输入功能详述]
     *
     * @param openid
     * @return SellerInfo
     * @author Rushing0711
     * @since 1.0.0
     */
    SellerInfo findSellerInfoByOpenid(String openid);
}
