/**
 * Created by Zyzzz on 2017/1/23.
 */

$(document).ready(function () {
    $("#???").click(function () {
        var id=hooyesQueryString("cid");
        var cookie=getcookie("ocookie");
        // alert(cookie);
        $.ajax({
            url:"/deleteCourse",
            type:"post",
            dataType:'json',
            async: false,
            data:{cid:id,cookie:cookie},
            success:function (json) {
                // alert("success");
                console.log(JSON.stringify(json));
                //window.opener=null;
                //window.open('course_detail.html?cid='+id,'_self');
            },
            error:function (request) {
                alert("error");
                alert(JSON.stringify(request));
            }
        });
    });
});

