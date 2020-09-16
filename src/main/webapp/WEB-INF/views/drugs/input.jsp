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
    <title>药品仓库管理系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link href="/style/basic_layout.css" rel="stylesheet" type="text/css">
    <link href="/style/common_style.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="/js/jquery/jquery.js"></script>
    <script type="text/javascript" src="/js/commonAll.js"></script>
<body>
<form name="editForm" namespace="/" action="drugs_saveOrUpdate" method="post" id="editForm">
    <div id="container">
        <div id="nav_links">
            <span style="color: #1A5CC6;" >药品编辑</span>
            <div id="page_close">
                <a>
                    <img src="/images/common/page_close.png" width="20" height="20" style="vertical-align: text-top;"/>
                </a>
            </div>
        </div>
        <input type="hidden" name="drug.id" value="<s:property value='drug.id'/>"/>
        <div class="ui_content">
            <table cellspacing="0" cellpadding="0" width="100%" align="left" border="0">
                <tr>
                    <td class="ui_text_rt" width="140">药品名称</td>
                    <td class="ui_text_lt">
                        <input type="text" name="drug.name" class="ui_input_txt02" value="<s:property value='drug.name'/>"/>
                    </td>
                </tr>
                <tr>
                    <td class="ui_text_rt" width="140">所属分类</td>
                    <td class="ui_text_lt">
                        <input type="text" name="drug.type" class="ui_input_txt02" value="<s:property value='drug.type'/>"/>
                    </td>
                </tr>
                <tr>
                    <td class="ui_text_rt" width="140">是否可用</td>
                    <td class="ui_text_lt">
                        <s:select list="{true,false}" name="drug.state" value="<s:property value='drug.state'/>"/>
                    </td>
                </tr>
                <tr>
                <td class="ui_text_rt" width="140">成本价格</td>
                <td class="ui_text_lt">
                    <input type="text" name="drug.costPrice" class="ui_input_txt02" value="<s:property value='drug.costPrice'/>"/>
                </td>
                </tr>
                <tr>
                <td class="ui_text_rt" width="140">出售价格</td>
                <td class="ui_text_lt">
                    <input type="text" name="drug.sellPrice" class="ui_input_txt02" value="<s:property value='drug.sellPrice'/>"/>
                </td>
                </tr>
                <tr>
                    <td class="ui_text_rt" width="140">生产日期</td>
                    <td class="ui_text_lt">
                        <input type="text" name="drug.productionDate" class="ui_input_txt02" value="<s:property value='drug.productionDate'/>"/>
                    </td>
                </tr>
                <tr>
                    <td class="ui_text_rt" width="140">保质日期</td>
                    <td class="ui_text_lt">
                        <input type="text" name="drug.lifeDate" class="ui_input_txt02" value="<s:property value='drug.lifeDate'/>"/>
                    </td>
                </tr>
                <tr>
                    <td class="ui_text_rt" width="140">是否为特殊药品</td>
                    <td class="ui_text_lt">
                        <s:select list="{true,false}" name="drug.especial" value="<s:property value='drug.especial'/>"/>
                    </td>
                </tr>
                <tr>
                    <td class="ui_text_rt" width="140">药品数量</td>
                    <td class="ui_text_lt">
                        <input type="text" name="drug.number" class="ui_input_txt02" value="<s:property value='drug.number'/>"/>
                    </td>
                </tr>

                <tr>
                    <td class="ui_text_lt">
                        &nbsp;<input type="submit" value="保存编辑" class="ui_input_btn01"/>
                        &nbsp;<input id="cancelbutton" type="button" value="重置" class="ui_input_btn01"/>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</form>
</body>
</html>
