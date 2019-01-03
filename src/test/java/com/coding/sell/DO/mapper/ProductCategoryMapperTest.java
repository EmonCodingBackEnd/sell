package com.coding.sell.DO.mapper;

import com.coding.sell.DO.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryMapperTest {

    @Autowired private ProductCategoryMapper mapper;

    @Test
    @Transactional
    public void insertByMap() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("category_name", "师兄最不爱");
        map.put("category_type", 101);
        int result = mapper.insertByMap(map);
        Assert.assertEquals(1, result);
    }

    @Test
    @Transactional
    public void insertByObject() throws Exception {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("师兄最不爱");
        productCategory.setCategoryType(102);
        int result = mapper.insertByObject(productCategory);
        Assert.assertEquals(1, result);
    }

    @Test
    public void findByCategoryType() throws Exception {
        ProductCategory result = mapper.findByCategoryType(0);
        Assert.assertNotNull(result);
    }

    @Test
    @Transactional
    public void updateByCategoryType() throws Exception {
        int result = mapper.updateByCategoryType("师兄最不爱的分类", 102);
        Assert.assertEquals(0, result);
    }

    @Test
    @Transactional
    public void updateByObject() throws Exception {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("师兄最不爱");
        productCategory.setCategoryType(102);
        int result = mapper.updateByObject(productCategory);
        Assert.assertEquals(0, result);
    }

    @Test
    @Transactional
    public void deleteByCategoryType() throws Exception {
        int result = mapper.deleteByCategoryType(102);
        Assert.assertEquals(0, result);
    }

    @Test
    public void selectByCategoryType() throws Exception {
        ProductCategory result = mapper.selectByCategoryType(0);
        Assert.assertNotNull(result);
    }
}
