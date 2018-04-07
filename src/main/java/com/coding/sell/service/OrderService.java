/*
 * 文件名称：OrderService.java
 * 系统名称：[系统名称]
 * 模块名称：[模块名称]
 * 软件版权：Copyright (c) 2011-2018, liming20110711@163.com All Rights Reserved.
 * 功能说明：[请在此处输入功能说明]
 * 开发人员：Rushing0711
 * 创建日期：20180211 23:22
 * 修改记录：
 * <Version>        <DateSerial>        <Author>        <Description>
 * 1.0.0            20180211-01         Rushing0711     M201802112322 新建文件
 ********************************************************************************/
package com.coding.sell.service;

import com.coding.sell.DTO.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * [请在此输入功能简述].
 *
 * <p>创建时间: <font style="color:#00FFFF">20180211 23:22</font><br>
 * [请在此输入功能详述]
 *
 * @author Rushing0711
 * @version 1.0.0
 * @since 1.0.0
 */
public interface OrderService {

    /**
     * 创建订单.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180211 23:49</font><br>
     * [请在此输入功能详述]
     *
     * @param orderDTO - 订单数据传输对象
     * @return OrderDTO
     * @author Rushing0711
     * @since 1.0.0
     */
    OrderDTO create(OrderDTO orderDTO);

    /**
     * 查询单个订单.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180211 23:49</font><br>
     * [请在此输入功能详述]
     *
     * @param orderId - 订单编号
     * @return OrderDTO
     * @author Rushing0711
     * @since 1.0.0
     */
    OrderDTO findOne(String orderId);

    /**
     * 查询单个订单列表.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180211 23:50</font><br>
     * [请在此输入功能详述]
     *
     * @param buyerOpenid - 买家微信Openid
     * @param pageable - 分页属性
     * @return org.springframework.data.domain.Page<OrderDTO>
     * @author Rushing0711
     * @since 1.0.0
     */
    Page<OrderDTO> findList(String buyerOpenid, Pageable pageable);

    /**
     * 取消订单.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180211 23:52</font><br>
     * [请在此输入功能详述]
     *
     * @param orderDTO - 订单数据传输对象
     * @return OrderDTO
     * @author Rushing0711
     * @since 1.0.0
     */
    OrderDTO cancel(OrderDTO orderDTO);

    /**
     * 完结订单.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180211 23:53</font><br>
     * [请在此输入功能详述]
     *
     * @param orderDTO -
     * @return OrderDTO
     * @author Rushing0711
     * @since 1.0.0
     */
    OrderDTO finish(OrderDTO orderDTO);

    /**
     * 支付订单.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180211 23:54</font><br>
     * [请在此输入功能详述]
     *
     * @param orderDTO
     * @return OrderDTO
     * @author Rushing0711
     * @since 1.0.0
     */
    OrderDTO paid(OrderDTO orderDTO);

    /**
     * 查询订单列表.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180220 12:48</font><br>
     * [请在此输入功能详述]
     *
     * @param pageable -
     * @return org.springframework.data.domain.Page<OrderDTO>
     * @author Rushing0711
     * @since 1.0.0
     */
    Page<OrderDTO> findList(Pageable pageable);
}
