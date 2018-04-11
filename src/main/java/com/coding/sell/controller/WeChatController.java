/*
 * 文件名称：WeiXinController.java
 * 系统名称：[系统名称]
 * 模块名称：[模块名称]
 * 软件版权：Copyright (c) 2011-2018, liming20110711@163.com All Rights Reserved.
 * 功能说明：[请在此处输入功能说明]
 * 开发人员：Rushing0711
 * 创建日期：20180327 22:35
 * 修改记录：
 * <Version>        <DateSerial>        <Author>        <Description>
 * 1.0.0            20180327-01         Rushing0711     M201803272235 新建文件
 ********************************************************************************/
package com.coding.sell.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * [请在此输入功能简述].
 *
 * <p>创建时间: <font style="color:#00FFFF">20180327 22:36</font><br>
 * [请在此输入功能详述]
 *
 * @author Rushing0711
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController
@RequestMapping("/wechat")
@Slf4j
public class WeChatController {

    @GetMapping("/checkSignature")
    public String checkSignature(
            @RequestParam(value = "signature") String signature,
            @RequestParam("timestamp") String timestamp,
            @RequestParam("nonce") String nonce,
            @RequestParam("echostr") String echostr) {
        log.info(
                "【微信公众平台接入】signature={},timestamp={},nonce={},echostr={}",
                signature,
                timestamp,
                nonce,
                echostr);

        String token = "emonnote";
        // 1、将token、timestamp、nonce三个参数进行字典序排序
        String[] array = {token, timestamp, nonce};
        Arrays.sort(array);
        // 2、将三个参数字符串拼接成一个字符串进行sha1加密
        String arrayString = StringUtils.arrayToDelimitedString(array, "");
        String arraySecret = DigestUtils.sha1Hex(arrayString);

        log.info("【微信公众平台接入】sha1加密结果={}", arraySecret);

        // 3、开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
        if (arraySecret.equals(signature)) {
            return echostr;
        } else {
            return "";
        }
    }
}
