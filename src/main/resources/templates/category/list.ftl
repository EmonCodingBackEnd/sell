<!--
 文件名称：list.ftl
 系统名称：[系统名称]
 模块名称：[模块名称]
 软件版权：Copyright (c) 2011-2018, liming20110711@163.com All Rights Reserved.
 功能说明：[请在此处输入功能说明]
 开发人员：Rushing0711
 创建日期：20180221 19:05
 修改记录：
 <Version>        <DateSerial>        <Author>        <Description>
 1.0.0            20180221-01         Rushing0711     M201802211905 新建文件
 -->
<html>
<head>
    <meta charset="UTF-8">
    <title>卖家商品列表</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-bordered table-hover">
                <thead>
                <tr>
                    <th>类目id</th>
                    <th>名字</th>
                    <th>type</th>
                    <th>创建时间</th>
                    <th>修改时间</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <#list categoryList as category>
                <tr>
                    <td>${category.categoryId}</td>
                    <td>${category.categoryName}</td>
                    <td>${category.categoryType}</td>
                    <td>${category.createTime}</td>
                    <td>${category.updateTime}</td>
                    <td><a href="/sell/seller/category/index?categoryId=${category.categoryId}">修改</a></td>
                </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
