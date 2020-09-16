<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <script type="text/javascript" src="/js/jquery/jquery-3.0.0.min.js"></script>
    <script type="text/javascript">
        $(function(){
            $("#submitBtn").click(function(){
                var fileName = $("#excel").val();
                var suffix = (fileName.substr(fileName.lastIndexOf("."))).toUpperCase();
                //验证文件后缀名
                if(".jpg" != suffix && ".png" != suffix){
                    alert("文件格式只能是.jpg或者.png");
                    return;
                }
                $("#myForm").submit();
            });
        });
    </script>
</head>

<body>
<form name="editForm" namespace="/" action="systemmanager_updateIngo" method="post" enctype="multipart/form-data">
    <div id="container">
        <div id="nav_links">
            <span style="color: #1A5CC6;" >自身信息编辑</span>
        </div>
        <input type="hidden" name="purchaseManager.id" value="<s:property value='#inmanager.id'/>"/>
        <input type="hidden" name="purchaseManager.username" value="<s:property value='#inmanager.username'/>"/>
        <input type="hidden" name="purchaseManager.picture" value="<s:property value='#inmanager.picture'/>"/>
        <div class="ui_content">
            <table cellspacing="0" cellpadding="0" width="100%" align="left" border="0">
                <tr>
                    <td class="ui_text_rt" width="140">姓名</td>
                    <td class="ui_text_lt">
                        <input type="text" name="purchaseManager.name" class="ui_input_txt02" value="<s:property value='#inmanager.name'/>"/>
                    </td>
                </tr>
                <tr>
                    <td class="ui_text_rt" width="140">账号密码</td>
                    <td class="ui_text_lt">
                        <input type="text" name="purchaseManager.password" class="ui_input_txt02" value="<s:property value='#inmanager.password'/>"/>
                    </td>
                </tr>
                <tr>
                    <td class="ui_text_rt" width="140">性别</td>
                    <td class="ui_text_lt">
                        <s:select list="{true,false}" name="purchaseManager.gender" value="<s:property value='#inmanager.gender'/>"/>
                    </td>
                </tr>
                <tr>
                    <td class="ui_text_rt" width="140">年龄</td>
                    <td class="ui_text_lt">
                        <input type="text" name="purchaseManager.age" class="ui_input_txt02" value="<s:property value='#inmanager.age'/>"/>
                    </td>
                </tr>
                <tr>
                    <td class="ui_text_rt" width="140">身份证号</td>
                    <td class="ui_text_lt">
                        <input type="text" name="purchaseManager.Resident_ID_Number" class="ui_input_txt02" value="<s:property value='#inmanager.Resident_ID_Number'/>"/>
                    </td>
                </tr>
                <tr>
                    <td class="ui_text_lt">工作照</td>
                    <td><img src="<s:property value='#inmanager.picture'/>"/></td>
                </tr>
                <tr>
                    <td class="ui_text_rt" width="140">工作照修改</td>
                    <td><input type="file" name="fileImage"/></td>
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