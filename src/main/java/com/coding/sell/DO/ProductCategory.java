/*
 * 文件名称：ProductCategory.java
 * 系统名称：[系统名称]
 * 模块名称：[模块名称]
 * 软件版权：Copyright (c) 2011-2018, liming20110711@163.com All Rights Reserved.
 * 功能说明：[请在此处输入功能说明]
 * 开发人员：Rushing0711
 * 创建日期：20180209 08:07
 * 修改记录：
 * <Version>        <DateSerial>        <Author>        <Description>
 * 1.0.0            20180209-01         Rushing0711     M201802090807 新建文件
 ********************************************************************************/
package com.coding.sell.DO;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 类目.
 *
 * <p>创建时间: <font style="color:#00FFFF">20180209 08:07</font><br>
 * [请在此输入功能详述]
 *
 * @author Rushing0711
 * @version 1.0.0
 * @since 1.0.0
 */
@Entity
// [lm's ps]: 20180407 14:20 如果不添加 @DynamicUpdate 注解，当更新其他字段时不会更新 updateTime 字段。
@DynamicUpdate
@Data
@NoArgsConstructor
public class ProductCategory {

    /**
     * 类目id.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180209 08:10</font><br>
     * [请在此输入功能详述]
     *
     * @since 1.0.0
     */
    @Id @GeneratedValue private Integer categoryId;

    /**
     * 类目名字.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180209 08:10</font><br>
     * [请在此输入功能详述]
     *
     * @since 1.0.0
     */
    private String categoryName;

    /**
     * 类目编号.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180209 08:11</font><br>
     * [请在此输入功能详述]
     *
     * @since 1.0.0
     */
    private Integer categoryType;

    /**
     * 创建时间.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180221 20:07</font><br>
     * [请在此输入功能详述]
     *
     * @since 1.0.0
     */
    private Date createTime;

    /**
     * 更新时间.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180221 20:09</font><br>
     * [请在此输入功能详述]
     *
     * @since 1.0.0
     */
    private Date updateTime;

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}