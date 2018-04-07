-- 创建用户
create user 'springboot'@'%' identified by 'SpringBoot@123';
-- 授权用户
grant all privileges on *.* to 'springboot'@'%' with grant option;

-- 创建数据库
CREATE DATABASE IF NOT EXISTS springboot DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- 使用数据库
use springboot;

select * from product_category;
select * from product_info;

select * from order_master;
select * from order_detail;

select * from seller_info;