<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/1 0001
  Time: 21:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>供应商信息</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link href="/style/basic_layout.css" rel="stylesheet" type="text/css">
    <link href="/style/common_style.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="/js/jquery/jquery.js"></script>
    <script type="text/javascript" src="/js/commonAll.js"></script>
<body>
<form name="editForm" namespace="/" action="supplier_saveOrUpdate" method="post" id="editForm">
    <div id="container">
        <div id="nav_links">
            <span style="color: #1A5CC6;" >供应商修改</span>
            <div id="page_close">
                <a>
                    <img src="/images/common/page_close.png" width="20" height="20" style="vertical-align: text-top;"/>
                </a>
            </div>
        </div>
        <input type="hidden" name="supplier.id" value="<s:property value='supplier.id'/>"/>
        <div class="ui_content">
            <table cellspacing="0" cellpadding="0" width="100%" align="left" border="0">
                <tr>
                    <td class="ui_text_rt" width="140">公司名称</td>
                    <td class="ui_text_lt">
                        <input type="text" name="supplier.name" class="ui_input_txt02" value="<s:property value='supplier.name'/>"/>
                    </td>
                </tr>
                <tr>
                    <td class="ui_text_rt" width="140">公司地址</td>
                    <td class="ui_text_lt">
                        <input type="text" name="supplier.address" class="ui_input_txt02" value="<s:property value='supplier.address'/>"/>
                    </td>
                </tr>
                <tr>
                <td class="ui_text_rt" width="140">公司邮箱</td>
                <td class="ui_text_lt">
                    <input type="text" name="supplier.email" class="ui_input_txt02" value="<s:property value='supplier.email'/>"/>
                </td>
                </tr>
                <tr>
                    <td class="ui_text_rt" width="140">联系电话</td>
                    <td class="ui_text_lt">
                        <input type="text" name="supplier.phoneNumber" class="ui_input_txt02" value="<s:property value='supplier.phoneNumber'/>"/>
                    </td>
                </tr>
                <tr>
                    <td class="ui_text_rt" width="140">责任人</td>
                    <td class="ui_text_lt">
                        <input type="text" name="supplier.contactPerson" class="ui_input_txt02" value="<s:property value='supplier.contactPerson'/>"/>
                    </td>
                </tr>
                <tr>
                    <td class="ui_text_rt" width="140">转账银行</td>
                    <td class="ui_text_lt">
                        <input type="text" name="supplier.bank" class="ui_input_txt02" value="<s:property value='supplier.bank'/>"/>
                    </td>
                </tr>
                <tr>
                    <td class="ui_text_rt" width="140">支付方式</td>
                    <td class="ui_text_lt">
                        <input type="text" name="supplier.paymentManner" class="ui_input_txt02" value="<s:property value='supplier.paymentManner'/>"/>
                    </td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
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
