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
    <link rel="stylesheet" href="/Bootstrap/css/bootstrap.min.css">
    <link href="/style/basic_layout.css" rel="stylesheet" type="text/css">
    <link href="/style/common_style.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="/js/jquery/jquery-3.0.0.min.js"/>
    <script type="text/javascript" src="/js/commonAll.js"/>
    <style>
        .alt td{ background:black !important;}
    </style>
    <script type="text/javascript">
            $(function() {
                $("#selectgo  option[value='<s:property value="#pagesize.limitSize"/>'] ").attr("selected", true)
                $("#selectgo").change(function () {
                    if ($("#keyGo").val() == '') {
                        window.location.href = "/supplier.action?limitSize=" + $("#selectgo").val();
                    }else {
                        window.location.href = "/supplier.action?limitSize=" + $("#selectgo").val() +"&keyGo="+ $("#keyGo").val();
                    }
                })
            })
        function go() {
            if ($("#keyGo").val() == '') {
                window.location.href = "/supplier.action?currentPage=" + $("input#pageGo").val() + "&limitSize=" + $("#selectgo").val();
            }else {
                window.location.href = "/supplier.action?currentPage=" + $("input#pageGo").val() + "&limitSize=" + $("#selectgo").val() +"&keyGo="+ $("#keyGo").val();
            }
        }
        function go1() {
            if ($("#keyGo").val() == '') {
                window.location.href="/supplier.action?currentPage=1" +"&limitSize=" +$("#selectgo").val();
            }else {
                window.location.href="/supplier.action?currentPage=1" +"&limitSize=" +$("#selectgo").val() + "&keyGo="+ $("#keyGo").val();
            }
        }
        function go2() {
            if ($("#keyGo").val() == '') {
                window.location.href="/supplier.action?currentPage=<s:property value="#pagesize.prevPage"/>" +"&limitSize=" +$("#selectgo").val();
            }else {
                window.location.href="/supplier.action?currentPage=<s:property value="#pagesize.prevPage"/>" +"&limitSize=" +$("#selectgo").val() +"&keyGo=" + $("#keyGo").val();
            }
        }
        function go3() {
            if ($("#keyGo").val() == '') {
                window.location.href="/supplier.action?currentPage=<s:property value="#pagesize.nextPage"/>" +"&limitSize=" +$("#selectgo").val();
            }else {
                window.location.href="/supplier.action?currentPage=<s:property value="#pagesize.nextPage"/>" +"&limitSize=" +$("#selectgo").val() +"&keyGo=" + $("#keyGo").val();
            }
        }
        function go4() {
            if ($("#keyGo").val() == '') {
                window.location.href="/supplier.action?currentPage=<s:property value="#pagesize.lastPage"/>" +"&limitSize=" +$("#selectgo").val();
            }else {
                window.location.href="/supplier.action?currentPage=<s:property value="#pagesize.lastPage"/>" +"&limitSize=" +$("#selectgo").val() +"&keyGo=" + $("#keyGo").val();
            }
        }
        function go5() {
            window.location.href="/supplier.action?currentPage=<s:property value="#pagesize.currentPage"/>" +"&limitSize=" +$("#selectgo").val() +"&keyGo=" + $("#keyGo").val();
        }
    </script>
    <title>供应商管理</title>
    <style>
        .alt td{ background:black !important;}
    </style>
    <script type="text/javascript">
        $(function(){
            $(".btn_input").click(function(){
                window.location.href=$(this).data("url");
            });
        });
    </script>
</head>
<body>
<form id="searchForm" action="#" method="post">
        <input type="text" id="keyGo" class="ui_select02" value="<s:property value='#keyGo'/>"/><input type="button" class="ui_input_btn01" value="关键字查询" onclick="go5()"/>
        <a href="/supplier_input.action"><input type="button" value="新增" class="ui_input_btn01"/></a>
        <div class="ui_content">
            <div class="ui_tb">
                <table class="table table-striped table-border">
                    <tr>
                        <th width="30"><input type="checkbox" id="all" /></th>
                        <th>编号</th>
                        <th>公司名称</th>
                        <th>公司地址</th>
                        <th>公司邮箱</th>
                        <th>联系电话</th>
                        <th>责任人</th>
                        <th>转账银行</th>
                        <th>支付方式</th>
                        <th>操作</th>
                    </tr>
                    <tbody>
                    <s:iterator value="#suppliers">
                        <tr>
                            <th width="30"><input type="checkbox"/></th>
                            <th><s:property value="id"/></th>
                            <th><s:property value="name"/></th>
                            <th><s:property value="address"/></th>
                            <th><s:property value="email"/></th>
                            <th><s:property value="phoneNumber"/></th>
                            <th><s:property value="contactPerson"/></th>
                            <th><s:property value="bank"/></th>
                            <th><s:property value="paymentManner"/></th>
                            <th><a href="/supplier_input.action?supplier.id=<s:property value="id"/>&supplier.name=<s:property value="name"/>
                            &supplier.address=<s:property value="address"/>&supplier.email=<s:property value="email"/>
                            &supplier.phoneNumber=<s:property value="phoneNumber"/>&supplier.contactPerson=<s:property value="contactPerson"/>
                            &supplier.bank=<s:property value="bank"/>&supplier.paymentManner=<s:property value="paymentManner"/>">编辑</a>||<a href="/supplier_delete.action?supplier.id=<s:property value="id"/>">删除</a></th>
                        </tr>
                    </s:iterator>
                    </tbody>
                </table>
            </div>
            <div class="ui_tb_h30">
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
                        转到第<input type="text" id="pageGo" class="ui_select02"/>页
                        <input type="button" class="ui_input_btn01" value="跳转" onclick="go()"/>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>
</body>
</html>
