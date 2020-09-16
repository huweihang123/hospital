<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/1 0001
  Time: 21:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="/Bootstrap/css/bootstrap.min.css">
    <script type="text/javascript" src="/My97DatePicker/WdatePicker.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="/js/jquery/jquery-3.0.0.min.js"></script>
    <script type="text/javascript" src="/js/commonAll.js"></script>
    <title>仓库管理</title>
    <style>
        .alt td{ background:black !important;}
    </style>
</head>
<body>
<div class="container" style="width: 100%">
    <table id="tablename" style="width: 120%;" class="table table-striped table-border">
        <thead>
        <tr>
            <th>序号</th>
            <th>姓名</th>
            <th>数量</th>
            <th>总价值</th>
            <th>种类</th>
            <th>备注</th>
        </tr>
        </thead>
        <tbody>
        <s:iterator value="#outputDurges" var="outputDrug">
                <tr><td>${outputDrug.id}</td>
                <td>${outputDrug.name}</td>
                <td>${outputDrug.number}</td>
                <td>${outputDrug.price}</td>
                <td>${outputDrug.type}</td>
                <td>${outputDrug.remarks}</td>
                </tr>
         </s:iterator>
        </tbody>
    </table>
</div>
</body>
</html>