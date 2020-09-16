function indrugs() {
    $("iframe").attr("src", "inputForm_echarts");
}
function outdrugs() {
    $("iframe").attr("src", "outputForm_echarts");
}
function outformsGet(){
    $("iframe").attr("src", "outputForm");
}
function inPutFormGet() {
    $("iframe").attr("src", "inputForm");
}
function warehouseshow() {
    $("iframe").attr("src","warehouse.action");
}
function informationUpdate(){
    var name = $("#person").val().substring(0,3)
    $("iframe").attr("src", "systemmanager_oneself?name="+name);
}
function inmanager(){
    $("iframe").attr("src","systemmanager_inmanager");
}
function outmanager(){
    $("iframe").attr("src","systemmanager_outmanager");
};
$(function () {
    $("#person").hide();
    $("#first").show();
    $("#second").hide();
    $("#third").hide();
    var day = new Date();
    time = day.getFullYear() + "-" + day.getMonth() + "-" + day.getDate() + " " + day.getHours() + ":" + day.getMinutes();
    $("#day_day").text(time);
    $("#left_tab1").click(function () {
        $("#first").show();
        $("#second").hide();
        $("#third").hide();
        $('#left_tab1').attr('class','selected');
        $('#left_tab2').removeClass();
        $('#left_tab3').removeClass();
        $("#nav_module img").attr("src","images/common/module_1.png");
    })
    $("#left_tab2").click(function () {
        $("#first").hide();
        $("#second").show();
        $("#third").hide();
        $('#left_tab2').attr('class','selected');
        $('#left_tab1').removeClass();
        $('#left_tab3').removeClass();
        $("#nav_module img").attr("src","images/common/module_2.png");

    })
    $("#left_tab3").click(function () {
        $("#first").hide();
        $("#second").hide();
        $("#third").show();
        $('#left_tab3').attr('class','selected');
        $('#left_tab2').removeClass();
        $('#left_tab1').removeClass();
        $("#nav_module img").attr("src","images/common/module_3.png");
    })
    function getData() {
        var day = new Date();
        if(day.getMinutes() >= 10) {
            time = day.getFullYear() + "-" + (day.getMonth() + 1) + "-" + day.getDate() + " " + day.getHours() + ":" + day.getMinutes();
        } else {
            time = day.getFullYear() + "-" + day.getMonth() + "-" + day.getDate() + " " + day.getHours() + ":0" + day.getMinutes();
        }
        $("#day_day").text(time);
    }
    setInterval(function(){
        getData();
    }, 3000);
})