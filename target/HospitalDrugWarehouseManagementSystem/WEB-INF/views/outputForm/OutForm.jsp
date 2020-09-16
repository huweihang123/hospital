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
    <script src="/js/jquery/outformes.js"></script>
    <script type="text/javascript" src="/js/jquery/jquery.table2excel.js"></script>
    <script type="text/javascript" src="/js/commonAll.js"></script>
    <title>仓库管理</title>
    <style>
        .alt td{ background:black !important;}
    </style>
</head>
<body>
<div class="container" style="width: 100%">
    <span>制表日期：<input type="text" id="time" onfocus="WdatePicker()"/></span>
    <span>制表人：<input type="text" id="persongo" class="ui_input_txt01"/></span>
    <span>所属仓库：<input type="text" id="warehousego" class="ui_input_txt01"/></span>
    <button onclick="gettrto()" class="btn btn-default">新增行</button>
    <button onclick="removettrto()" class="btn btn-default">删除行</button>
    <table id="tablename" style="width: 120%;" class="table table-striped table-border">
                <thead>
                <tr>
                    <th>序号</th>
                    <th>药品名称</th>
                    <th>所属种类</th>
                    <th>出货量</th>
                    <th>总价值</th>
                    <th>所属仓库</th>
                    <th>备注</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td><input type="text" value="1.0" style="border:none;background:transparent;"/></td>
                    <td><input type="text" style="border:none;background:transparent;"/></td>
                    <td><input type="text" style="border:none;background:transparent;"/></td>
                    <td><input type="text" style="border:none;background:transparent;"/></td>
                    <td><input type="text" style="border:none;background:transparent;"/></td>
                    <td><input type="text" style="border:none;background:transparent;"/></td>
                    <td><input type="text" style="border:none;background:transparent;"/></td>
                </tr>
                </tbody>
    </table>
    <button class="btn btn-default" onclick="getexcel()">上传本地excel</button>
    <button id="excel" class="btn btn-default">本地保存</button>
    <button class="btn btn-default" id="send" onclick="send()">提交报表</button>
    </div>
</body>
</html>