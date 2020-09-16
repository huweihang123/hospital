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
    <script src="/js/jquery/systemmanager.js"></script>
    <script type="text/javascript" src="/js/jquery/jquery.table2excel.js"></script>
    <script type="text/javascript" src="/js/commonAll.js"></script>
    <title>新增管理员</title>
    <style>
        .alt td{ background:black !important;}
    </style>
</head>
<body>
<div class="container" style="width: 100%">
    <a href="/systemmanager_updatein"/>新增</a>
    <table id="tablename" style="width: 120%;" class="table table-striped table-border">
        <thead>
        <tr>
            <th>序号</th>
            <th>姓名</th>
            <th>账号</th>
            <th>性别</th>
            <th>年龄</th>
            <th>身份证</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <s:iterator value="#purchaseManagers" var="purchasemanager">
                <tr><td>${purchasemanager.id}</td>
                <td>${purchasemanager.name}</td>
                <td>${purchasemanager.username}</td>
                <td>${purchasemanager.gender}</td>
                <td>${purchasemanager.age}</td>
                <td>${purchasemanager.resident_ID_Number}</td>
                    <td><a href="/systemmanager_updatein?inid=<s:property value="id"/>">编辑</a>||
                        <a href="/systemmanager_deletein?inid=<s:property value="id"/>">删除</a></td></tr>
         </s:iterator>
        </tbody>
    </table>
</div>
</body>
</html>