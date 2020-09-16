$(function(){
    var day = new Date();
    var time = day.getFullYear() + "-" + (day.getMonth()+1) + "-" + day.getDate() + "准确时间：" + day.getHours() + "：" +day.getMinutes() +  "-出货文档保存";
    $("td").attr("contenteditable","true");
        $("#excel").click(function () {
            $("#tablename").table2excel({
                // 不被导出的表格行的CSS class类
                exclude: ".noExl",
                // 导出的Excel文档的名称
                name: "Excel Document Name",
                // Excel文件的名称
                filename: time,
                //文件后缀名
                fileext: ".xls",
                //是否排除导出图片
                exclude_img: false,
                //是否排除导出超链接
                exclude_links: false,
                //是否排除导出输入框中的内容
                exclude_inputs: false
            });
        });
})
$(function () {
    setInterval(function () {
        if($("#time").val() == "" || $("#persongo").val() == "" || $("#warehousego").val() == ""){
            $("#send").attr("disabled",true);
        }else {
            $("#send").attr("disabled",false);
        }
    },1000)
})
function gettrto() {
    $("table").append("<tr><td>"+ ($("table").find("tr").length + ".0") +"</td><td></td><td></td><td></td><td></td><td></td><td></td></tr>");
    $("tr").css({"height":$("tr").height()});
    $("tr").attr("contenteditable","true");
}
function removettrto() {
    if(($("table").find("tr").length) >= 2) {
        $("tr:last").remove();
    }
}
function getexcel() {
    window.location.href="inputForm_upload";
}
function send() {
    var tableContext = new Array();
    $("#tablename").find("tr").each(function () {
        tableContext.push($(this).children('td:eq(0)').children('input').val())
        tableContext.push($(this).children('td:eq(1)').children('input').val())
        tableContext.push($(this).children('td:eq(2)').children('input').val())
        tableContext.push($(this).children('td:eq(3)').children('input').val())
        tableContext.push($(this).children('td:eq(4)').children('input').val())
        tableContext.push($(this).children('td:eq(5)').children('input').val())
        tableContext.push($(this).children('td:eq(6)').children('input').val())
        tableContext.push($(this).children('td:eq(7)').children('input').val())
        tableContext.push($(this).children('td:eq(8)').children('input').val())
        tableContext.push($(this).children('td:eq(9)').children('input').val())
    })
    var stringDome = tableContext.join()
        $.ajax({
            async: false,
            url: 'inputForm_dealTable',
            type: 'POST',
            tradition: true,
            data: {'stringDome': stringDome}
        })
        window.location.href = "inputForm_dealTable?tableTime=" + $("#time").val() + "&tablePerson=" + $("#persongo").val() + "&tableWarehouse=" + $("#warehousego").val();
}