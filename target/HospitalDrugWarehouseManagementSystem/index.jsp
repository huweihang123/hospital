<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<title>后台登录</title>
 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="/style/style.css" />
<style>
body{height:100%;background:#16a085;overflow:hidden;}
canvas{z-index:-1;position:absolute;}
.green {
 background-color: #0c9076;
 color: #fff;
}
</style>
<script src="/js/jquery/jquery-3.0.0.min.js"></script>
<script src="/js/jquery/verificationNumbers.js"></script>
<script src="/js/jquery/Particleground.js"></script>
<script>
$(document).ready(function() {
  //粒子背景特效
  createCode();
  $('body').particleground({
    dotColor: '#5cbdaa',
    lineColor: '#5cbdaa'
  });
});
</script>
</head>
<body>
<dl class="admin_login">
 <dt>
  <strong>星光医院医药仓库管理系统</strong>
  <em>Management System</em>
 </dt>
 <form id="submitForm" namespace="/" method="post">
 <dd class="user_icon">
  <input type="text" placeholder="账号" name="username" class="login_txtbx"/>
 </dd>
  <dd>
  <s:fielderror cssStyle="color: #5e5e5e">
   <s:param>loginError.username</s:param>
  </s:fielderror>
 </dd>
 <dd class="pwd_icon">
  <input type="password" placeholder="密码" name="password" class="login_txtbx"/>
 </dd>
  <dd>
 <label><s:fielderror cssStyle="color: #5e5e5e">
   <s:param>loginError.password</s:param>
 </s:fielderror></label>
 </dd>
 <dd class="val_icon">
  <div class="checkcode">
    <input type="text" id="J_codetext" name="check" placeholder="验证码" maxlength="4" class="login_txtbx">
    <canvas class="J_codeimg" id="myCanvas" onclick="createCode()">对不起，您的浏览器不支持canvas，请下载最新版浏览器!</canvas>
  </div>
  <input type="button" value="验证码核验" class="ver_btn" onClick="validate();">
 </dd>
 <dd>
  <div>
   <select id="manager" class="green">
    <option value="1" class="green">采购管理员</option>
    <option value="2" class="green">库存管理员</option>
    <option value="3" class="green">系统管理员</option>
   </select>
  </div>
 </dd>
 <dd>
  <input type="button" value="立即登陆" onclick="send()" class="submit_btn"/>
 </dd>
 </form>
 <dd>
  <p>© 2020-2021 like 版权所有</p>
  <p>陕A3-32123-21</p>
 </dd>
</dl>
</body>
</html>
