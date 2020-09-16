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
    <title>仓库更新</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link href="/style/basic_layout.css" rel="stylesheet" type="text/css">
    <link href="/style/common_style.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="/js/jquery/jquery-3.0.0.min.js"></script>
</head>
<body>
<form name="editForm" namespace="/" action="warehouse_saveOrUpdate" method="post" id="editForm">
    <div id="container">
        <div id="nav_links">
            <span style="color: #1A5CC6;" >仓库编辑</span>
            <div id="page_close">
                <a>
                    <img src="/images/common/page_close.png" width="20" height="20" style="vertical-align: text-top;"/>
                </a>
            </div>
        </div>
        <input type="hidden" name="warehouse.id" value="<s:property value='#warehouse.id'/>"/>
        <div class="ui_content">
            <table cellspacing="0" cellpadding="0" width="100%" align="left" border="0">
                <tr>
                    <td class="ui_text_rt" width="140">仓库名称</td>
                    <td class="ui_text_lt">
                        <input type="text" name="warehouse.name" class="ui_input_txt02" value="<s:property value='#warehouse.name'/>"/>
                    </td>
                </tr>
                <tr>
                    <td class="ui_text_rt" width="140">所在地址</td>
                    <td class="ui_text_lt">
                        <input type="text" name="warehouse.address" class="ui_input_txt02" value="<s:property value='#warehouse.address'/>"/>
                    </td>
                </tr>
                <tr>
                    <td class="ui_text_rt" width="140">创建日期</td>
                    <td class="ui_text_lt">
                        <input type="text" name="warehouse.createDate" class="ui_input_txt02" value="<s:property value='#warehouse.createDate'/>"/>
                    </td>
                </tr>
                <tr>
                    <td class="ui_text_rt" width="140">最大存储量</td>
                    <td class="ui_text_lt">
                        <input type="text" name="warehouse.Maxsize" class="ui_input_txt02" value="<s:property value='#warehouse.Maxsize'/>"/>
                    </td>
                </tr>
                <tr>
                <td class="ui_text_rt" width="140">剩余存储量</td>
                <td class="ui_text_lt">
                    <input type="text" name="warehouse.size" class="ui_input_txt02" value="<s:property value='#warehouse.size'/>"/>
                </td>
                </tr>
                <tr>
                <td class="ui_text_rt" width="140">药品价值</td>
                <td class="ui_text_lt">
                    <input type="text" name="warehouse.drugsCost" class="ui_input_txt02" value="<s:property value='#warehouse.drugsCost'/>"/>
                </td>
                </tr>
                <tr>
                    <td class="ui_text_lt">
                        <input type="submit" value="保存编辑" class="ui_input_btn01"/>
                        <input id="cancelbutton" type="button" value="重置" class="ui_input_btn01"/>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</form>
</body>
</html>
