/*
 * 文件名称：ProductInfo.java
 * 系统名称：[系统名称]
 * 模块名称：[模块名称]
 * 软件版权：Copyright (c) 2011-2018, liming20110711@163.com All Rights Reserved.
 * 功能说明：[请在此处输入功能说明]
 * 开发人员：Rushing0711
 * 创建日期：20180210 09:00
 * 修改记录：
 * <Version>        <DateSerial>        <Author>        <Description>
 * 1.0.0            20180210-01         Rushing0711     M201802100900 新建文件
 ********************************************************************************/
package com.coding.sell.DO;

import com.coding.sell.enums.ProductStatusEnum;
import com.coding.sell.utils.EnumUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品.
 *
 * <p>创建时间: <font style="color:#00FFFF">20180210 09:00</font><br>
 * [请在此输入功能详述]
 *
 * @author Rushing0711
 * @version 1.0.0
 * @since 1.0.0
 */
@Entity
@Data
@DynamicUpdate
public class ProductInfo {

    @Id private String productId;

    /**
     * 名字.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180210 09:01</font><br>
     * [请在此输入功能详述]
     *
     * @since 1.0.0
     */
    private String productName;

    /**
     * 单价.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180210 09:02</font><br>
     * [请在此输入功能详述]
     *
     * @since 1.0.0
     */
    private BigDecimal productPrice;

    /**
     * 库存.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180210 09:02</font><br>
     * [请在此输入功能详述]
     *
     * @since 1.0.0
     */
    private Integer productStock;

    /**
     * 描述.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180210 09:03</font><br>
     * [请在此输入功能详述]
     *
     * @since 1.0.0
     */
    private String productDescription;

    /**
     * 小图.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180210 09:03</font><br>
     * [请在此输入功能详述]
     *
     * @since 1.0.0
     */
    private String productIcon;

    /**
     * 状态.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180210 09:04</font><br>
     * 0-正常；1-下架； 参见：{@link ProductStatusEnum}
     *
     * @since 1.0.0
     */
    private Integer productStatus = ProductStatusEnum.UP.getCode();

    /**
     * 类目编号.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180210 09:05</font><br>
     * [请在此输入功能详述]
     *
     * @since 1.0.0
     */
    private Integer categoryType;

    /**
     * 创建时间.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180221 20:05</font><br>
     * [请在此输入功能详述]
     *
     * @since 1.0.0
     */
    private Date createTime;

    /**
     * 更新时间.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180221 20:06</font><br>
     * [请在此输入功能详述]
     *
     * @since 1.0.0
     */
    private Date updateTime;

    @JsonIgnore
    public ProductStatusEnum getProductStatusEnum() {
        return EnumUtil.getByCode(productStatus, ProductStatusEnum.class);
    }
}
