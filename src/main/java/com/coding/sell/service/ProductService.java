/*
 * 文件名称：ProductService.java
 * 系统名称：[系统名称]
 * 模块名称：[模块名称]
 * 软件版权：Copyright (c) 2011-2018, liming20110711@163.com All Rights Reserved.
 * 功能说明：[请在此处输入功能说明]
 * 开发人员：Rushing0711
 * 创建日期：20180210 09:27
 * 修改记录：
 * <Version>        <DateSerial>        <Author>        <Description>
 * 1.0.0            20180210-01         Rushing0711     M201802100927 新建文件
 ********************************************************************************/
package com.coding.sell.service;

import com.coding.sell.DO.ProductInfo;
import com.coding.sell.DTO.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 商品.
 *
 * <p>创建时间: <font style="color:#00FFFF">20180210 09:27</font><br>
 * [请在此输入功能详述]
 *
 * @author Rushing0711
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ProductService {

    ProductInfo findOne(String productId);

    /**
     * 查询所有在架商品列表.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180210 09:28</font><br>
     * [请在此输入功能详述]
     *
     * @return java.util.List<ProductInfo>
     * @author Rushing0711
     * @since 1.0.0
     */
    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    void increaseStock(List<CartDTO> cartDTOList);

    void decreaseStock(List<CartDTO> cartDTOList);

    /**
     * 上架.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180221 16:25</font><br>
     * [请在此输入功能详述]
     *
     * @param productId -
     * @return ProductInfo
     * @author Rushing0711
     * @since 1.0.0
     */
    ProductInfo onSale(String productId);

    /**
     * 下架.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180221 16:25</font><br>
     * [请在此输入功能详述]
     *
     * @param productId
     * @return ProductInfo
     * @author Rushing0711
     * @since 1.0.0
     */
    ProductInfo offSale(String productId);
}
