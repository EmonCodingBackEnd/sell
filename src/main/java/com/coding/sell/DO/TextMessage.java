/*
 * 文件名称：TextMessage.java
 * 系统名称：[系统名称]
 * 模块名称：[模块名称]
 * 软件版权：Copyright (c) 2011-2018, liming20110711@163.com All Rights Reserved.
 * 功能说明：[请在此处输入功能说明]
 * 开发人员：Rushing0711
 * 创建日期：20180412 08:32
 * 修改记录：
 * <Version>        <DateSerial>        <Author>        <Description>
 * 1.0.0            20180412-01         Rushing0711     M201804120832 新建文件
 ********************************************************************************/
package com.coding.sell.DO;

import lombok.Data;

/**
 * [请在此输入功能简述].
 *
 * <p>创建时间: <font style="color:#00FFFF">20180412 08:33</font><br>
 * [请在此输入功能详述]
 *
 * @author Rushing0711
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
public class TextMessage {

    /** 开发者微信号. */
    private String ToUserName;

    /** 发送方帐号（一个OpenID）. */
    private String FromUserName;

    /** 消息创建时间 （整型）. */
    private Long CreateTime;

    /** text. */
    private String MsgType;

    /** 文本消息内容. */
    private String Content;

    /** 消息id，64位整型. */
    private String MsgId;
}
