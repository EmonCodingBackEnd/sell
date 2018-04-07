/*
 * 文件名称：PayServiceImpl.java
 * 系统名称：[系统名称]
 * 模块名称：[模块名称]
 * 软件版权：Copyright (c) 2011-2018, liming20110711@163.com All Rights Reserved.
 * 功能说明：[请在此处输入功能说明]
 * 开发人员：Rushing0711
 * 创建日期：20180217 22:57
 * 修改记录：
 * <Version>        <DateSerial>        <Author>        <Description>
 * 1.0.0            20180217-01         Rushing0711     M201802172257 新建文件
 ********************************************************************************/
package com.coding.sell.service.impl;

import com.coding.sell.DTO.OrderDTO;
import com.coding.sell.enums.ResultEnum;
import com.coding.sell.exception.SellException;
import com.coding.sell.service.OrderService;
import com.coding.sell.service.PayService;
import com.coding.sell.utils.JsonUtil;
import com.coding.sell.utils.MathUtil;
import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundRequest;
import com.lly835.bestpay.model.RefundResponse;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * [请在此输入功能简述].
 *
 * <p>创建时间: <font style="color:#00FFFF">20180217 22:57</font><br>
 * [请在此输入功能详述]
 *
 * @author Rushing0711
 * @version 1.0.0
 * @since 1.0.0
 */
@Service
@Slf4j
public class PayServiceImpl implements PayService {

    @Autowired private BestPayServiceImpl bestPayService;

    @Autowired private OrderService orderService;

    @Override
    public PayResponse create(OrderDTO orderDTO) {
        // TODO: 2018/2/19 需要具有微信支付权限的公众号来调试，等待ing
        PayRequest payRequest = new PayRequest();
        payRequest.setOpenid(orderDTO.getBuyerOpenid());
        payRequest.setOrderAmount(orderDTO.getOrderAmount().doubleValue());
        payRequest.setOrderId(orderDTO.getOrderId());
        payRequest.setOrderName(orderDTO.getBuyerName());
        payRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_H5);

        log.info("【微信支付】 request={}", JsonUtil.toJson(payRequest));
        PayResponse payResponse = bestPayService.pay(payRequest);
        log.info("【微信支付】 response={}", JsonUtil.toJson(payResponse));
        return payResponse;
    }

    @Override
    public PayResponse notify(String notifyData) {
        // 1.验证签名
        // 2.支付的状态
        PayResponse payResponse = bestPayService.asyncNotify(notifyData);
        log.info("【微信支付】异步通知, payResponse={}", JsonUtil.toJson(payResponse));

        // 3.支付金额
        {
            // 查询订单
            OrderDTO orderDTO = orderService.findOne(payResponse.getOrderId());

            // 判断订单是否存在
            if (orderDTO == null) {
                log.error("【微信支付】异步通知, 订单不存在, orderId={}", payResponse.getOrderId());
                throw new SellException(ResultEnum.ORDER_NOT_EXIST);
            }

            // 判断金额是否一致(0.10, 0.1)
            if (MathUtil.equals(
                    payResponse.getOrderAmount(), orderDTO.getOrderAmount().doubleValue())) {
                log.error(
                        "【微信支付】异步通知, 订单金额不一致, orderId={}, 微信通知金额={}, 系统金额={}",
                        payResponse.getOrderId(),
                        payResponse.getOrderAmount(),
                        orderDTO.getOrderAmount());
                throw new SellException(ResultEnum.WXPAY_NOTIFY_MONEY_VERIFY_ERROR);
            }
            // 修改订单的支付状态
            orderService.paid(orderDTO);
        }

        // 4.支付人(下单人 == 支付人)

        return payResponse;
    }

    /**
     * 退款.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180219 22:01</font><br>
     * [请在此输入功能详述]
     *
     * @param orderDTO
     * @return com.lly835.bestpay.model.RefundResponse
     * @author Rushing0711
     * @since 1.0.0
     */
    @Override
    public RefundResponse refund(OrderDTO orderDTO) {
        RefundRequest refundRequest = new RefundRequest();
        refundRequest.setOrderId(orderDTO.getOrderId());
        refundRequest.setOrderAmount(orderDTO.getOrderAmount().doubleValue());
        refundRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_H5);

        log.info("【微信退款】 request={}", JsonUtil.toJson(refundRequest));
        RefundResponse refundResponse = bestPayService.refund(refundRequest);
        log.info("【微信退款】 response={}", JsonUtil.toJson(refundResponse));
        return refundResponse;
    }
}
