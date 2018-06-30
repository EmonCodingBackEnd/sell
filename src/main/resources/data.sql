-- 数据文件
INSERT INTO selldb.product_category
(category_id, category_name, category_type, create_time, update_time)
VALUES(1, '热销榜', 0, '2018-02-09 16:03:18.000', '2018-02-09 16:03:18.000');

INSERT INTO selldb.product_info
(product_id, product_name, product_price, product_stock, product_description, product_icon, product_status, category_type, create_time, update_time)
VALUES('10000001', '皮蛋粥', 3.20, 100, '很好喝的粥', 'http://xxxxx.jpg', 0, 0, '2018-04-07 16:58:17.000', '2018-04-07 16:58:17.000');
INSERT INTO selldb.product_info
(product_id, product_name, product_price, product_stock, product_description, product_icon, product_status, category_type, create_time, update_time)
VALUES('10000002', '皮皮虾', 3.20, 100, '很好吃的虾', 'http://xxxxx.jpg', 0, 0, '2018-04-07 17:19:27.000', '2018-04-07 17:19:27.000');

INSERT INTO selldb.order_master
(order_id, buyer_name, buyer_phone, buyer_address, buyer_openid, order_amount, order_status, pay_status, create_time, update_time)
VALUES('10000001', '师兄', '12345678900', '慕课网', '110110', 19.20, 0, 0, '2018-04-07 18:31:32.000', '2018-04-07 18:31:32.000');

INSERT INTO selldb.order_detail
(detail_id, order_id, product_id, product_name, product_price, product_quantity, product_icon, create_time, update_time)
VALUES('10000001', '10000001', '10000001', '皮蛋粥', 3.20, 3, 'http://xxxxx.jpg', '2018-04-07 18:44:37.000', '2018-04-07 18:44:37.000');
INSERT INTO selldb.order_detail
(detail_id, order_id, product_id, product_name, product_price, product_quantity, product_icon, create_time, update_time)
VALUES('10000002', '10000001', '10000002', '皮皮虾', 3.20, 3, 'http://xxxxx.jpg', '2018-04-07 18:44:37.000', '2018-04-07 18:44:37.000');

