<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html lang="zh-CN">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>主页面</title>
	<link href="/style/main_css.css" rel="stylesheet" type="text/css" />
	<link href="/style/zTreeStyle.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="/js/jquery/jquery-3.0.0.min.js"></script>
	<script type="text/javascript" src="/js/commonAll.js"></script>
	<script type="text/javascript" src="/js/jquery/stockmanager.js"></script>
</head>
<body>
	<input id="person" value="<s:property value='#stockManager.name'/>"/>
    <div id="top">
		<div id="top_links">
			<div id="top_op">
				<ul>
					<li>
						<label>所属仓库：</label>
						<span id="warehousename"><s:property value="#warehouse.name"/></span>
					</li>
					<li>
						<img alt="今天是" src="images/common/date.jpg">：
						<span id="day_day"></span>
					</li>
					<li>
						<img alt="当前用户" src="images/common/user.jpg">：
						<span><s:property value="#stockManager.name"/></span>
					</li>
				</ul> 
			</div>
			<div id="top_close">
				<s:a action="logout" target="_parent">
					<img alt="退出系统" title="退出系统" src="images/common/close.jpg" style="position: relative; top: 10px; left: 25px;">
				</s:a>
			</div>
		</div>
	</div>
    <!-- side menu start -->
	<div id="side">
		<div id="left_menu">
		 	<ul id="TabPage2" style="height:200px; margin-top:50px;">
				<li id="left_tab1" class="selected" title="业务模块" data-rootmenu="business">
					<img alt="业务模块" title="业务模块" src="images/common/1_hover.jpg" width="33" height="31">
				</li>
				<li id="left_tab2" title="系统管理" data-rootmenu="systemManage">
					<img alt="系统管理" title="系统管理" src="images/common/2.jpg" width="33" height="31">
				</li>		
				<li id="left_tab3" title="报表" data-rootmenu="charts">
					<img alt="报表" title="报表" src="images/common/3.jpg" width="33" height="31">
				</li>
			</ul>
		 </div>
		 <div id="left_menu_cnt">
		 	<div id="nav_module">
		 		<img src="images/common/module_1.png" width="210" height="58"/>
		 	</div>
		 	<div id="nav_resource">
		 		<ul id="dleft_tab1" class="ztree">
					<div id="first">
						<button onclick="formsGet()">出货报表填报</button>
						<button onclick="outPutFormGet()">出货填报查询</button>
						<button onclick="outPutEchartshow()">出货药品图表</button>
					</div>
					<div id="second">
						<button id="drugs" onclick="drugsGet()">药品查询编辑</button>
						<button id="supplier" onclick="supplierGet()">供应商查询查询</button>
						<button id="warehouse" onclick="warehouseGet()">仓库查询编辑</button>
					</div>
						<div id="third">
							<button id="oneself" onclick="informationUpdate()">身份信息修改</button>
						</div>
				</ul>
		 	</div>
		 </div>
	</div>
    <!-- side menu start -->
    <div id="top_nav">
	 	<span id="here_area">当前位置：业务模块&nbsp;>&nbsp;业务处理</span>
	</div>
    <div id="main">
		<iframe id="drugshtml"  style="border:0px" width= "100%" height= "100%"/>
	</div>
</body>
</html>
   
 