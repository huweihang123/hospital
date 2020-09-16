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
    <link href="/style/common_style.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="/Bootstrap/css/bootstrap.min.css">
    <script type="text/javascript" src="/js/jquery/jquery-3.0.0.min.js"/>
    <script type="text/javascript" src="/js/commonAll.js"></script>
    <title>仓库管理</title>
    <script type="text/javascript">
        $(function() {
            $("#selectgo  option[value='<s:property value="#pagesize.limitSize"/>'] ").attr("selected", true)
            $("#selectgo").change(function () {
                if ($("#keyGo").val() == '') {
                    window.location.href = "/inputForm" +
                        ".action?limitSize=" + $("#selectgo").val();
                }else {
                    window.location.href = "/inputForm" +
                        ".action?limitSize=" + $("#selectgo").val() +"&keyGo=";
                }
            })
        })
        function go() {
            if ($("#keyGo").val() == '') {
                window.location.href = "/inputForm" +
                    ".action?currentPage=" + $("input#pageGo").val() + "&limitSize=" + $("#selectgo").val();
            }else {
                window.location.href = "/inputForm" +
                    ".action?currentPage=" + $("input#pageGo").val() + "&limitSize=" + $("#selectgo").val();
            }
        }
        function go1() {
            if ($("#keyGo").val() == '') {
                window.location.href="/inputForm" +
                    ".action?currentPage=1" +"&limitSize=" +$("#selectgo").val();
            }else {
                window.location.href="/inputForm" +
                    ".action?currentPage=1" +"&limitSize=" +$("#selectgo").val() + "&keyGo=";
            }
        }
        function go2() {
            if ($("#keyGo").val() == '') {
                window.location.href="/inputForm" +
                    ".action?currentPage=<s:property value="#pagesize.prevPage"/>" +"&limitSize=" +$("#selectgo").val();
            }else {
                window.location.href="/inputForm" +
                    ".action?currentPage=<s:property value="#pagesize.prevPage"/>" +"&limitSize=" +$("#selectgo").val();
            }
        }
        function go3() {
            if ($("#keyGo").val() == '') {
                window.location.href="/inputForm" +
                    ".action?currentPage=<s:property value="#pagesize.nextPage"/>" +"&limitSize=" +$("#selectgo").val();
            }else {
                window.location.href="/inputForm" +
                    ".action?currentPage=<s:property value="#pagesize.nextPage"/>" +"&limitSize=" +$("#selectgo").val();
            }
        }
        function go4() {
            if ($("#keyGo").val() == '') {
                window.location.href="/inputForm" +
                    ".action?currentPage=<s:property value="#pagesize.lastPage"/>" +"&limitSize=" +$("#selectgo").val();
            }else {
                window.location.href="/inputForm" +
                    ".action?currentPage=<s:property value="#pagesize.lastPage"/>" +"&limitSize=" +$("#selectgo").val();
            }
        }
        function go5() {
            window.location.href="/inputForm" +
                ".action?currentPage=<s:property value="#pagesize.currentPage"/>" +"&limitSize=" +$("#selectgo").val();
        }
    </script>
</head>
<body>
<form id="searchForm" action="#inputForm" method="post">
    <div id="container">
        <input type="text" id="keyGo" class="ui_select02" value="<s:property value='#keyGo'/>"/><input type="button" class="ui_input_btn01" value="关键字查询" onclick="go5()"/>
        <div>
            <div>
                <table class="table table-striped table-border">
                    <tr>
                        <th width="30"><input type="checkbox" id="all"/></th>
                        <th>编号</th>
                        <th>订单时间</th>
                        <th>备注</th>
                        <th>报表人</th>
                        <th>操作</th>
                    </tr>
                    <tbody>
                    <s:iterator value="#inputForms">
                        <tr>
                            <th width="30"><input type="checkbox"/></th>
                            <th><s:property value="id"/></th>
                            <th><s:property value="time"/></th>
                            <th><s:property value="other"/></th>
                            <th><s:property value="manager.name"/></th>
                            <th><a href="/inputForm_findCareful?informID=<s:property value="id"/>">详细查看</a></th>
                        </tr>
                    </s:iterator>
                    </tbody>
                </table>
            </div>
            <div class="ui_tb_h30">
                <div class="ui_flt" style="height: 30px; line-height: 30px;">
                    共有
                    <span class="ui_txt_bold04"><s:property value="#pagesize.totalCount"/></span>
                    条记录，当前第
                    <span class="ui_txt_bold04"><s:property value="#pagesize.currentPage"/>/<s:property value="#pagesize.totalPage"/></span>
                    页
                </div>
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
</form>
</body>
</html>