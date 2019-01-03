-- --------------------------------------------------------------------------------
-- spring.datasource.initialize=true时，自动调用
-- 初始化数据脚本
-- 要求：
--    1、保证sql可以重复执行，也就是insert之前先delete（删除表还是某一条，根据需要而定）
--    2、sql关键字推荐大写
-- --------------------------------------------------------------------------------
-- 示例
-- DELETE FROM `user` WHERE id=1;
-- INSERT INTO `user` (id, create_time, modify_time, version, acct, intro, mgr_shops, mobile, name, pwd, role_id, sex, status) VALUES(1, '2018-04-16 18:46:01.000', '2018-04-16 18:46:04.000', 0, 'acct', NULL, '123456,678910', '13777485757', 'wtf', 'e10adc3949ba59abbe56e057f20f883e', 0, NULL, '1');

-- 商品分类表
DELETE FROM product_category WHERE category_id=1;
INSERT INTO product_category (category_id, category_name, category_type, create_time, update_time) VALUES(1, '热销榜', 0, '2018-02-09 16:03:18.000', '2018-02-09 16:03:18.000');

-- 商品表
DELETE FROM product_info WHERE product_id='10000001';
INSERT INTO product_info (product_id, product_name, product_price, product_stock, product_description, product_icon, product_status, category_type, create_time, update_time) VALUES('10000001', '皮蛋粥', 3.20, 100, '很好喝的粥', 'http://xxxxx.jpg', 0, 0, '2018-04-07 16:58:17.000', '2018-04-07 16:58:17.000');
DELETE FROM product_info WHERE product_id='10000002';
INSERT INTO product_info (product_id, product_name, product_price, product_stock, product_description, product_icon, product_status, category_type, create_time, update_time) VALUES('10000002', '皮皮虾', 3.20, 100, '很好吃的虾', 'http://xxxxx.jpg', 0, 0, '2018-04-07 17:19:27.000', '2018-04-07 17:19:27.000');

-- 订单表
DELETE FROM order_master WHERE order_id='10000001';
INSERT INTO order_master (order_id, buyer_name, buyer_phone, buyer_address, buyer_openid, order_amount, order_status, pay_status, create_time, update_time) VALUES('10000001', '师兄', '12345678900', '慕课网', '110110', 19.20, 0, 0, '2018-04-07 18:31:32.000', '2018-04-07 18:31:32.000');

-- 订单详情表
DELETE FROM order_detail WHERE detail_id='10000001';
INSERT INTO order_detail (detail_id, order_id, product_id, product_name, product_price, product_quantity, product_icon, create_time, update_time) VALUES('10000001', '10000001', '10000001', '皮蛋粥', 3.20, 3, 'http://xxxxx.jpg', '2018-04-07 18:44:37.000', '2018-04-07 18:44:37.000');
DELETE FROM order_detail WHERE detail_id='10000002';
INSERT INTO order_detail (detail_id, order_id, product_id, product_name, product_price, product_quantity, product_icon, create_time, update_time) VALUES('10000002', '10000001', '10000002', '皮皮虾', 3.20, 3, 'http://xxxxx.jpg', '2018-04-07 18:44:37.000', '2018-04-07 18:44:37.000');

