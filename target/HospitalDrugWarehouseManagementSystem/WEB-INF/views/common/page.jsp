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
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="/style/basic_layout.css" rel="stylesheet" type="text/css">
    <link href="/style/common_style.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="/js/jquery/jquery-3.0.0.min.js"/>
    <script type="text/javascript" src="/js/commonAll.js"/>
    <title>仓库管理</title>
    <style>
        .alt td{ background:black !important;}
    </style>
</head>
<body>
<div class="ui_tb_h30">
    <div class="ui_flt" style="height: 30px; line-height: 30px;">
        共有
        <span class="ui_txt_bold04"><s:property value="#pagesize.totalCount"/></span>
        条记录，当前第
        <span class="ui_txt_bold04"><s:property value="#pagesize.currentPage"/>/<s:property value="#pagesize.totalPage"/></span>
        页
    </div>
    <div class="ui_frt">
        <input type="button" value="首页" class="ui_input_btn01" onclick="go1()"/>
        <input type="button" value="上一页" class="ui_input_btn01" onclick="go2()"/>
        <input type="button" value="下一页" class="ui_input_btn01" onclick="go3()"/>
        <input type="button" value="末页" class="ui_input_btn01" onclick="go4()"/>

        <select value="<s:property value="#pagesize.limitSize"/>" id="selectgo" class="ui_select02">
            <option value="5">5</option>
            <option value="10">10</option>
            <option value="20">20</option>
            <option value="50">50</option>
            <option value="100">100</option>
        </select>
        转到第<input type="text" id="pageGo" class="ui_input_txt01"/>页
        <input type="button" class="ui_input_btn01" value="跳转" onclick="go()"/>
    </div>
</div>
</body>