/**
 * Created by zhangshuang on 2017/1/17.
 */
$(document).ready(function () {
    $("#submit").click(function () {
        var id=hooyesQueryString("cid");
        var comment=$("#comment").val();
        // alert("id:"+id+"comment:"+comment);

        var cookie=getcookie("cookie");
        // alert(cookie);
        $.ajax({
           url:"/AddComments",
            type:"post",
            dataType:'json',
            async: false,
            data:{comments:comment,courseid:id,cookie:cookie},
            success:function (json) {
               // alert("success");
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

