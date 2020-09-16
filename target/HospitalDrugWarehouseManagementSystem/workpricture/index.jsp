<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>仓库管理系统</title>
<script type="text/javascript" src="../js/jquery/jquery-3.0.0.min.js"></script>
<link rel="stylesheet" href="/Bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/Bootstrap/js/bootstrap.min.js">
<script type="text/javascript">
		function send(){
				if(parseInt($("#manager").val())==1){
					$("#submitForm").attr("action","purchasemanager_login").submit();
				} else if(parseInt($("#manager").val())==2){
					$("#submitForm").attr("action","stockmanager_login").submit();
				}else if(parseInt($("#manager").val())==3){
					$("#submitForm").attr("action","systemmanager_login").submit();
				};
		}
</script>
<style>
	.center-in-center{
		position: absolute;
		top: 50%;
		left: 50%;
		-webkit-transform: translate(-50%, -50%);
		-moz-transform: translate(-50%, -50%);
		-ms-transform: translate(-50%, -50%);
		-o-transform: translate(-50%, -50%);
		transform: translate(-50%, -50%);
	}
</style>
</head>
	<body>
				<div id="login_form" class="center-in-center">
					<form id="submitForm" namespace="/" method="post">
						<div id="login_tip">
							<span id="login_err" class="sty_txt2">
								 <s:fielderror>
									 <s:param>loginError.username</s:param>
									 <s:param>loginError.password</s:param>
								 </s:fielderror>
							</span>
						</div>
						<div class="form-group">
							账&nbsp;&nbsp;&nbsp;&nbsp;号：<input type="text" name="username" class="username" id="name">
						</div>
						<div>
							密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="password" class="pwd" id="pwd">
						</div>
						<div id="btn_area">
							<div class="form-group">
								<select id="manager" class="selectpicker">
									<option value="1">采购管理员</option>
									<option value="2">库存管理员</option>
									<option value="3">系统管理员</option>
								</select>
							</div>
							<input type="button" class="btn btn-default" onclick="send()" value="登  录">
							<input type="reset" class="btn btn-default" id="login_ret" value="重 置">
						</div>
					</form>
				</div>
	</body>
</html>