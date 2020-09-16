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
                if(".XLS" != suffix && ".XLSX" != suffix){
                    alert("文件格式只能是.XLS或者.XLSX");
                    return;
                }
                $("#myForm").submit();
            });
        });
    </script>

</head>

<body>
<s:form id="myForm" namespace="/" action="parseexcel" method="post" enctype="multipart/form-data">
    <input type="file" name="excel" id="excel"/><br/>
    <input id="submitBtn" type="button" value="提交" />
</s:form>
</body>
</html>