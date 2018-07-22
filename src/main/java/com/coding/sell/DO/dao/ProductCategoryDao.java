/*
 * 文件名称：ProductCategoryDao.java
 * 系统名称：[系统名称]
 * 模块名称：[模块名称]
 * 软件版权：Copyright (c) 2011-2018, liming20110711@163.com All Rights Reserved.
 * 功能说明：[请在此处输入功能说明]
 * 开发人员：Rushing0711
 * 创建日期：20180722 13:18
 * 修改记录：
 * <Version>        <DateSerial>        <Author>        <Description>
 * 1.0.0            20180722-01         Rushing0711     M201807221318 新建文件
 ********************************************************************************/
package com.coding.sell.DO.dao;

import com.coding.sell.DO.mapper.ProductCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class ProductCategoryDao {

    @Autowired ProductCategoryMapper mapper;

    int insertByMap(Map<String, Object> map) {
        return mapper.insertByMap(map);
    };
}
