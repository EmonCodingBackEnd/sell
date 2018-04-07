/*
 * 文件名称：KeyUtil.java
 * 系统名称：[系统名称]
 * 模块名称：[模块名称]
 * 软件版权：Copyright (c) 2011-2018, liming20110711@163.com All Rights Reserved.
 * 功能说明：[请在此处输入功能说明]
 * 开发人员：Rushing0711
 * 创建日期：20180212 08:26
 * 修改记录：
 * <Version>        <DateSerial>        <Author>        <Description>
 * 1.0.0            20180212-01         Rushing0711     M201802120826 新建文件
 ********************************************************************************/
package com.coding.sell.utils;

import java.util.Random;

/**
 * [请在此输入功能简述].
 *
 * <p>创建时间: <font style="color:#00FFFF">20180212 08:26</font><br>
 * [请在此输入功能详述]
 *
 * @author Rushing0711
 * @version 1.0.0
 * @since 1.0.0
 */
public class KeyUtil {

    /**
     * 生成唯一的主键.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180212 08:27</font><br>
     * 格式：时间+随机数
     *
     * @return java.lang.String
     * @author Rushing0711
     * @since 1.0.0
     */
    public static synchronized String getUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
}
