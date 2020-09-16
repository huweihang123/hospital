<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>ECharts</title>
    <!-- 引入 echarts.js -->
    <script src="/js/jquery/echarts.min.js"></script>
    <script src="/js/jquery/jquery-3.0.0.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#one").hide();
            $("#two").hide();
            $("#three").hide();
            $("#four").hide();
            $("#five").hide();
            $("#six").hide();
            $("#serven").hide();
        })
    </script>
</head>
<body>
<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="main" style="width: 600px;height:400px;"></div>
<input id="one" type="text" value="<s:property value='one' escape='false'/>"></input>
<input id="two" type="text" value="<s:property value='two'/>"></input>
<input id="three" type="text" value="<s:property value='three'/>"></input>
<input id="four" type="text" value="<s:property value='four'/>"></input>
<input id="five" type="text" value="<s:property value='five'/>"></input>
<input id="six" type="text" value="<s:property value='six'/>"></input>
<input id="serven" type="text" value="<s:property value='serven'/>"></input>
</body>
<script>
    var myChart = echarts.init(document.getElementById('main'));
    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '近七次次药品总出库量（柱状图）'
        },
        tooltip: {},
        legend: {
            data:['出库量']
        },
        xAxis: {
            name: '报表次',
            data: ["第一次","第二次","第三次","第四次","第五次","第六次","第七次"]
        },
        yAxis: {},
        series: [{
            name: '出库量',
            type: 'bar',
            data: [ $("#one").val(), $("#two").val(), $("#three").val(), $("#four").val(),$("#five").val(), $("#six").val(),$("#serven").val()]
        }]
    };
    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
</script>
</html>