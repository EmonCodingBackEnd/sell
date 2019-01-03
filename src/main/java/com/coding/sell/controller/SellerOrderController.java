/*
 * 文件名称：SellerOrderController.java
 * 系统名称：[系统名称]
 * 模块名称：[模块名称]
 * 软件版权：Copyright (c) 2011-2018, liming20110711@163.com All Rights Reserved.
 * 功能说明：[请在此处输入功能说明]
 * 开发人员：Rushing0711
 * 创建日期：20180220 13:02
 * 修改记录：
 * <Version>        <DateSerial>        <Author>        <Description>
 * 1.0.0            20180220-01         Rushing0711     M201802201302 新建文件
 ********************************************************************************/
package com.coding.sell.controller;

import com.coding.sell.DTO.OrderDTO;
import com.coding.sell.enums.ResultEnum;
import com.coding.sell.exception.SellException;
import com.coding.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * 卖家端订单.
 *
 * <p>创建时间: <font style="color:#00FFFF">20180220 13:03</font><br>
 * [请在此输入功能详述]
 *
 * @author Rushing0711
 * @version 1.0.0
 * @since 1.0.0
 */
@Controller
@RequestMapping("/seller/order")
@Slf4j
public class SellerOrderController {

    @Autowired
    private OrderService orderService;

    // [lm's ps]: 20180220 16:44 http://localhost:8080/sell/seller/order/list?page=1&size=10
    /**
     * 订单列表.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180220 13:06</font><br>
     * [请在此输入功能详述]
     *
     * @param page - 第几页，从1页开始
     * @param size - 一页有多少条数据
     * @return org.springframework.web.servlet.ModelAndView
     * @author Rushing0711
     * @since 1.0.0
     */
    @GetMapping("/list")
    public ModelAndView list(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size,
            Map<String, Object> map) {
        PageRequest request = new PageRequest(page - 1, size);
        Page<OrderDTO> orderDTOPage = orderService.findList(request);
        map.put("orderDTOPage", orderDTOPage);
        map.put("currentPage", page);
        map.put("size", size);
        return new ModelAndView("order/list", map);
    }

    // [lm's ps]: 20180220 16:51 http://localhost:8080/sell/seller/order/cancel?orderId=11
    @GetMapping("/cancel")
    public ModelAndView cancel(@RequestParam("orderId") String orderId, Map<String, Object> map) {
        OrderDTO orderDTO = null;
        try {
            orderDTO = orderService.findOne(orderId);
            orderService.cancel(orderDTO);
        } catch (SellException e) {
            log.error("【卖家端取消订单】 发生异常", e);
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/error", map);
        }

        map.put("msg", ResultEnum.ORDER_CANCEL_SUCCESS.getMessage());
        map.put("url", "/sell/seller/order/list");
        return new ModelAndView("common/success", map);
    }

    // [lm's ps]: 20180220 19:14
    // http://localhost:8080/sell/seller/order/detail?orderId=1518480440632779845
    /**
     * 订单详情.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180220 19:04</font><br>
     * [请在此输入功能详述]
     *
     * @author Rushing0711
     * @version 1.0.0
     * @since 1.0.0
     */
    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam("orderId") String orderId, Map<String, Object> map) {
        OrderDTO orderDTO;
        try {
            orderDTO = orderService.findOne(orderId);
        } catch (SellException e) {
            log.error("【卖家端查看订单详情】 发生异常", e);
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/error", map);
        }

        map.put("orderDTO", orderDTO);
        return new ModelAndView("order/detail", map);
    }

    /**
     * 完结订单.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180220 22:27</font><br>
     * [请在此输入功能详述]
     *
     * @author Rushing0711
     * @version 1.0.0
     * @since 1.0.0
     */
    @GetMapping("/finish")
    public ModelAndView finish(@RequestParam("orderId") String orderId, Map<String, Object> map) {
        OrderDTO orderDTO;
        try {
            orderDTO = orderService.findOne(orderId);
            orderService.finish(orderDTO);
        } catch (SellException e) {
            log.error("【卖家端完结订单】 发生异常", e);
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/error", map);
        }

        map.put("msg", ResultEnum.ORDER_FINISH_SUCCESS.getMessage());
        map.put("url", "/sell/seller/order/list");
        return new ModelAndView("common/success", map);
    }
}
