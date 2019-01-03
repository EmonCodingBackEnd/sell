/*
 * 文件名称：SellerInfo.java
 * 系统名称：[系统名称]
 * 模块名称：[模块名称]
 * 软件版权：Copyright (c) 2011-2018, liming20110711@163.com All Rights Reserved.
 * 功能说明：[请在此处输入功能说明]
 * 开发人员：Rushing0711
 * 创建日期：20180221 23:00
 * 修改记录：
 * <Version>        <DateSerial>        <Author>        <Description>
 * 1.0.0            20180221-01         Rushing0711     M201802212300 新建文件
 ********************************************************************************/
package com.coding.sell.DO;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * [请在此输入功能简述].
 *
 * <p>创建时间: <font style="color:#00FFFF">20180221 23:00</font><br>
 * [请在此输入功能详述]
 *
 * @author Rushing0711
 * @version 1.0.0
 * @since 1.0.0
 */
@Entity
@Data
public class SellerInfo {

    @Id private String sellerId;

    private String username;

    private String password;

    private String openid;
}
