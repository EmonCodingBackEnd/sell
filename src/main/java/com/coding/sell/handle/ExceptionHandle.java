/*
 * 文件名称：ExceptionHandle.java
 * 系统名称：[系统名称]
 * 模块名称：[模块名称]
 * 软件版权：Copyright (c) 2011-2018, liming20110711@163.com All Rights Reserved.
 * 功能说明：[请在此处输入功能说明]
 * 开发人员：Rushing0711
 * 创建日期：20180204 18:21
 * 修改记录：
 * <Version>        <DateSerial>        <Author>        <Description>
 * 1.0.0            20180204-01         Rushing0711     M201802041821 新建文件
 ********************************************************************************/
package com.coding.sell.handle;

import com.coding.sell.VO.ResultVO;
import com.coding.sell.exception.SellException;
import com.coding.sell.utils.ResultVOUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * [请在此输入功能简述].
 *
 * <p>创建时间: <font style="color:#00FFFF">20180204 18:21</font><br>
 * [请在此输入功能详述]
 *
 * @author Rushing0711
 * @version 1.0.0
 * @since 1.0.0
 */
@ControllerAdvice
public class ExceptionHandle {

    public static final Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultVO handle(Exception e) {
        if (e instanceof SellException) {
            SellException sellException = (SellException) e;
            return ResultVOUtil.error(
                    sellException.getCode(), sellException.getMessage());
        } else {
            logger.error("【系统异常】{}", e);
            return ResultVOUtil.error(-1, "未知错误");
        }
    }
}
