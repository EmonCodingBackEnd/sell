/*
 * 文件名称：ProductCategoryMapper.java
 * 系统名称：[系统名称]
 * 模块名称：[模块名称]
 * 软件版权：Copyright (c) 2011-2018, liming20110711@163.com All Rights Reserved.
 * 功能说明：[请在此处输入功能说明]
 * 开发人员：Rushing0711
 * 创建日期：20180722 12:14
 * 修改记录：
 * <Version>        <DateSerial>        <Author>        <Description>
 * 1.0.0            20180722-01         Rushing0711     M201807221214 新建文件
 ********************************************************************************/
package com.coding.sell.DO.mapper;

import com.coding.sell.DO.ProductCategory;
import org.apache.ibatis.annotations.*;

import java.util.Map;

public interface ProductCategoryMapper {

    @Insert(
            "insert into product_category(category_name, category_type) values (#{category_name, jdbcType=VARCHAR}, #{category_type, jdbcType=INTEGER})")
    int insertByMap(Map<String, Object> map);

    @Insert(
            "insert into product_category(category_name, category_type) values (#{categoryName, jdbcType=VARCHAR}, #{categoryType, jdbcType=INTEGER})")
    int insertByObject(ProductCategory productCategory);

    @Select("select * from product_category where category_type = #{categoryType}")
    @Results({@Result(column = "category_type", property = "categoryType")})
    ProductCategory findByCategoryType(Integer categoryType);

    @Update(
            "update product_category set category_name = #{categoryName} where category_type = #{categoryType}")
    int updateByCategoryType(
            @Param("categoryName") String categoryName,
            @Param("categoryType") Integer categoryType);

    @Update(
            "update product_category set category_name = #{categoryName} where category_type = #{categoryType}")
    int updateByObject(ProductCategory productCategory);

    @Delete("delete from product_category where category_type = #{categoryType}")
    int deleteByCategoryType(Integer categoryType);

    ProductCategory selectByCategoryType(Integer categoryType);
}
