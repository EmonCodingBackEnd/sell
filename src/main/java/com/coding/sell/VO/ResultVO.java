/*
 * 文件名称：ResultVO.java
 * 系统名称：[系统名称]
 * 模块名称：[模块名称]
 * 软件版权：Copyright (c) 2011-2018, liming20110711@163.com All Rights Reserved.
 * 功能说明：[请在此处输入功能说明]
 * 开发人员：Rushing0711
 * 创建日期：20180210 22:33
 * 修改记录：
 * <Version>        <DateSerial>        <Author>        <Description>
 * 1.0.0            20180210-01         Rushing0711     M201802102233 新建文件
 ********************************************************************************/
package com.coding.sell.VO;

import lombok.Data;

/**
 * http请求返回的最外层对象.
 *
 * <p>创建时间: <font style="color:#00FFFF">20180210 22:33</font><br>
 * [请在此输入功能详述]
 *
 * @author Rushing0711
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
public class ResultVO<T> {

    /**
     * 错误码.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180210 22:35</font><br>
     * [请在此输入功能详述]
     *
     * @since 1.0.0
     */
    private Integer code;

    /**
     * 提示信息.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180210 22:35</font><br>
     * [请在此输入功能详述]
     *
     * @since 1.0.0
     */
    private String msg;

    /**
     * 具体内容.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180210 22:35</font><br>
     * [请在此输入功能详述]
     *
     * @since 1.0.0
     */
    private T data;
}
