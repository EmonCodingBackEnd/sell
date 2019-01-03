/*
 * 文件名称：WeixinController.java
 * 系统名称：[系统名称]
 * 模块名称：[模块名称]
 * 软件版权：Copyright (c) 2011-2018, liming20110711@163.com All Rights Reserved.
 * 功能说明：[请在此处输入功能说明]
 * 开发人员：Rushing0711
 * 创建日期：20180216 17:45
 * 修改记录：
 * <Version>        <DateSerial>        <Author>        <Description>
 * 1.0.0            20180216-01         Rushing0711     M201802161745 新建文件
 ********************************************************************************/
package com.coding.sell.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * [请在此输入功能简述].
 *
 * <p>创建时间: <font style="color:#00FFFF">20180216 17:45</font><br>
 * [请在此输入功能详述]
 *
 * @author Rushing0711
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeixinController {

    // [lm's ps]: 20180216 22:37 测试地址： https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxf46908d1b94ffc6c&redirect_uri=http%3A%2F%2Fexp.mynatapp.cc/sell/weixin/auth&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect
    @GetMapping("/auth")
    public void auth(@RequestParam("code") String code) {
        log.info("进入auth方法。。。");
        log.info("code={}", code);
        String url =
                "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wxf46908d1b94ffc6c&secret=26c765de9bbe93f5b131856bd107da25&code="
                        + code
                        + "&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        log.info(response);
    }
}
