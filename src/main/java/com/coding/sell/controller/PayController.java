/*
 * 文件名称：PayController.java
 * 系统名称：[系统名称]
 * 模块名称：[模块名称]
 * 软件版权：Copyright (c) 2011-2018, liming20110711@163.com All Rights Reserved.
 * 功能说明：[请在此处输入功能说明]
 * 开发人员：Rushing0711
 * 创建日期：20180217 22:51
 * 修改记录：
 * <Version>        <DateSerial>        <Author>        <Description>
 * 1.0.0            20180217-01         Rushing0711     M201802172251 新建文件
 ********************************************************************************/
package com.coding.sell.controller;

import com.coding.sell.DTO.OrderDTO;
import com.coding.sell.enums.ResultEnum;
import com.coding.sell.exception.SellException;
import com.coding.sell.service.OrderService;
import com.coding.sell.service.PayService;
import com.lly835.bestpay.model.PayResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * [请在此输入功能简述].
 *
 * <p>创建时间: <font style="color:#00FFFF">20180217 22:51</font><br>
 * [请在此输入功能详述]
 *
 * @author Rushing0711
 * @version 1.0.0
 * @since 1.0.0
 */
@Controller
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PayService payService;

    // [lm's ps]: 20180220 13:12 http://localhost:8080/sell/pay/create?orderId=1518535962039682677&returnUrl=http://www.imooc.com
    @GetMapping("/create")
    public ModelAndView create(
            @RequestParam("orderId") String orderId,
            @RequestParam("returnUrl") String returnUrl,
            Map<String, Object> map) {
        // 1.查询订单
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null) {
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

        // 2.发起支付
        PayResponse payResponse = payService.create(orderDTO);

        map.put("payResponse", payResponse);
        map.put("returnUrl", returnUrl);

        return new ModelAndView("pay/create", map);
    }

    /**
     * 微信异步通知.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180219 17:43</font><br>
     * [请在此输入功能详述]
     *
     * @param notifyData -
     * @return void
     * @author Rushing0711
     * @since 1.0.0
     */
    @PostMapping("/notify")
    public ModelAndView notify(@RequestBody String notifyData) {
        payService.notify(notifyData);

        // 返回给微信处理结果
        return new ModelAndView("pay/succes");
    }
}
