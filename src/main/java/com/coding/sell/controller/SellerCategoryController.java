/*
 * 文件名称：SellerCategoryController.java
 * 系统名称：[系统名称]
 * 模块名称：[模块名称]
 * 软件版权：Copyright (c) 2011-2018, liming20110711@163.com All Rights Reserved.
 * 功能说明：[请在此处输入功能说明]
 * 开发人员：Rushing0711
 * 创建日期：20180221 18:42
 * 修改记录：
 * <Version>        <DateSerial>        <Author>        <Description>
 * 1.0.0            20180221-01         Rushing0711     M201802211842 新建文件
 ********************************************************************************/
package com.coding.sell.controller;

import com.coding.sell.DO.ProductCategory;
import com.coding.sell.exception.SellException;
import com.coding.sell.form.CategoryForm;
import com.coding.sell.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * 买家类目.
 *
 * <p>创建时间: <font style="color:#00FFFF">20180221 18:42</font><br>
 * [请在此输入功能详述]
 *
 * @author Rushing0711
 * @version 1.0.0
 * @since 1.0.0
 */
@Controller
@RequestMapping("/seller/category")
public class SellerCategoryController {

    @Autowired
    private CategoryService categoryService;

    // [lm's ps]: 20180221 20:17 http://localhost:8080/sell/seller/category/list
    /**
     * 类目列表.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180221 18:48</font><br>
     * [请在此输入功能详述]
     *
     * @param map
     * @return org.springframework.web.servlet.ModelAndView
     * @author Rushing0711
     * @since 1.0.0
     */
    @GetMapping("/list")
    public ModelAndView list(Map<String, Object> map) {
        List<ProductCategory> categoryList = categoryService.findAll();
        map.put("categoryList", categoryList);
        return new ModelAndView("category/list", map);
    }

    /**
     * 展示.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180221 20:22</font><br>
     * [请在此输入功能详述]
     *
     * @param categoryId -
     * @param map -
     * @return org.springframework.web.servlet.ModelAndView
     * @author Rushing0711
     * @since 1.0.0
     */
    @GetMapping("/index")
    public ModelAndView index(
            @RequestParam(value = "categoryId", required = false) Integer categoryId,
            Map<String, Object> map) {
        if (categoryId != null) {
            ProductCategory productCategory = categoryService.findOne(categoryId);
            map.put("productCategory", productCategory);
        }

        return new ModelAndView("category/index", map);
    }

    /**
     * 保存/更新.
     *
     * <p>创建时间: <font style="color:#00FFFF">20180221 20:49</font><br>
     * [请在此输入功能详述]
     *
     * @param categoryForm -
     * @param bindingResult -
     * @param map -
     * @return org.springframework.web.servlet.ModelAndView
     * @author Rushing0711
     * @since 1.0.0
     */
    @PostMapping("/save")
    public ModelAndView save(
            @Valid CategoryForm categoryForm,
            BindingResult bindingResult,
            Map<String, Object> map) {
        if (bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/sell/seller/category/index");
            return new ModelAndView("common/error", map);
        }

        ProductCategory productCategory = new ProductCategory();
        try {
            if (categoryForm.getCategoryId() != null) {
                productCategory = categoryService.findOne(categoryForm.getCategoryId());
            }
            BeanUtils.copyProperties(categoryForm, productCategory);
            categoryService.save(productCategory);
        } catch (SellException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/category/index");
            return new ModelAndView("common/error", map);
        }

        map.put("url", "/sell/seller/category/list");
        return new ModelAndView("common/success", map);
    }
}
