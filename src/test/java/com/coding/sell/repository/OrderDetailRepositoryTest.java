/*
 * 文件名称：OrderDetailRepositoryTest.java
 * 系统名称：[系统名称]
 * 模块名称：[模块名称]
 * 软件版权：Copyright (c) 2011-2018, liming20110711@163.com All Rights Reserved.
 * 功能说明：[请在此处输入功能说明]
 * 开发人员：Rushing0711
 * 创建日期：20180211 22:12
 * 修改记录：
 * <Version>        <DateSerial>        <Author>        <Description>
 * 1.0.0            20180211-01         Rushing0711     M201802112212 新建文件
 ********************************************************************************/
package com.coding.sell.repository;

import com.coding.sell.DO.OrderDetail;
import com.coding.sell.utils.KeyUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

/**
 * [请在此输入功能简述].
 *
 * <p>创建时间: <font style="color:#00FFFF">20180211 22:12</font><br>
 * [请在此输入功能详述]
 *
 * @author Rushing0711
 * @version 1.0.0
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired private OrderDetailRepository repository;

    private static final String DEFAULT_PRODUCT_ID = "10000001";

    private static final String DEFAULT_ORDER_ID = "10000001";

    @Test
    @Transactional
    public void saveTest() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId(KeyUtil.getUniqueKey());
        orderDetail.setOrderId(KeyUtil.getUniqueKey());
        orderDetail.setProductIcon("http://xxxxx.jpg");
        orderDetail.setProductId(DEFAULT_PRODUCT_ID);
        orderDetail.setProductName("皮蛋粥");
        orderDetail.setProductPrice(new BigDecimal(2.2));
        orderDetail.setProductQuantity(3);

        OrderDetail result = repository.save(orderDetail);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByOrderId() throws Exception {
        List<OrderDetail> orderDetailList = repository.findByOrderId(DEFAULT_ORDER_ID);
        Assert.assertNotEquals(0, orderDetailList.size());
    }
}
