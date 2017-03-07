/**
 * Created by cyy on 2017/3/7.
 */


function getcookie(objname){//获取指定名称的cookie的值
    var arrstr = document.cookie.split("; ");
    for(var i = 0;i < arrstr.length;i ++){
        var temp = arrstr[i].split("=");
        if(temp[0] == objname) return unescape(temp[1]);
    }
}

$(document).ready(function () {
    $("#submit").click(function () {

        var nickname=$("#nickname").val();
        var age = $("#age").val();
        var address = $("#address").val();
        var phone = $("#phone").val();

        alert("age:"+nickname+"age:"+age);
        var cookie=getcookie("cookie");
        alert(cookie);
        $.ajax({
            url:"/ModfityStudent",
            type:"post",
            dataType:'json',
            async: false,
            data:{cookie:cookie,nickname:nickname,age:age,address:address,phone:phone},
            success:function (json) {
                alert("success");
                console.log(JSON.stringify(json));
                window.opener=null;
                window.open('course_detail.html?cid='+id,'_self');

            },
            error:function (request) {
                alert("error");
                alert(JSON.stringify(request));
            }
        });
    });
});
