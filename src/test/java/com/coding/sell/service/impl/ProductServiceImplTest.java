/*
 * 文件名称：ProductServiceImplTest.java
 * 系统名称：[系统名称]
 * 模块名称：[模块名称]
 * 软件版权：Copyright (c) 2011-2018, liming20110711@163.com All Rights Reserved.
 * 功能说明：[请在此处输入功能说明]
 * 开发人员：Rushing0711
 * 创建日期：20180210 19:11
 * 修改记录：
 * <Version>        <DateSerial>        <Author>        <Description>
 * 1.0.0            20180210-01         Rushing0711     M201802101911 新建文件
 ********************************************************************************/
package com.coding.sell.service.impl;

import com.coding.sell.DO.ProductInfo;
import com.coding.sell.enums.ProductStatusEnum;
import com.coding.sell.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

/**
 * [请在此输入功能简述].
 *
 * <p>创建时间: <font style="color:#00FFFF">20180210 19:12</font><br>
 * [请在此输入功能详述]
 *
 * @author Rushing0711
 * @version 1.0.0
 * @since 1.0.0
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired private ProductServiceImpl productService;

    private static final String DEFAULT_PRODUCT_ID = "10000001";

    @Test
    public void findOne() throws Exception {
        ProductInfo productInfo = productService.findOne(DEFAULT_PRODUCT_ID);
        Assert.assertEquals(DEFAULT_PRODUCT_ID, productInfo.getProductId());
    }

    @Test
    public void findUpAll() throws Exception {
        List<ProductInfo> productInfoList = productService.findUpAll();
        Assert.assertNotEquals(0, productInfoList.size());
    }

    @Test
    public void findAll() throws Exception {
        PageRequest request = new PageRequest(0, 2);
        Page<ProductInfo> productInfoPage = productService.findAll(request);
        log.info("【测试】商品总数={}", productInfoPage.getTotalElements());
        Assert.assertNotEquals(0, productInfoPage.getTotalElements());
    }

    @Test
    @Transactional
    public void save() throws Exception {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId(KeyUtil.getUniqueKey());
        productInfo.setProductName("皮皮虾");
        productInfo.setProductPrice(new BigDecimal(3.2));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("很好吃的虾");
        productInfo.setProductIcon("http://xxxxx.jpg");
        productInfo.setProductStatus(ProductStatusEnum.UP.getCode());
        productInfo.setCategoryType(0);

        ProductInfo result = productService.save(productInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void onSale() throws Exception {
        ProductInfo result = productService.onSale(DEFAULT_PRODUCT_ID);
        Assert.assertEquals(ProductStatusEnum.UP, result.getProductStatusEnum());
    }

    @Test
    public void offSale() throws Exception {
        ProductInfo result = productService.offSale(DEFAULT_PRODUCT_ID);
        Assert.assertEquals(ProductStatusEnum.DOWN, result.getProductStatusEnum());
    }
}
