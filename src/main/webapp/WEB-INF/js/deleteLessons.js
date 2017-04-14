/**
 * Created by Zyzzz on 2017/4/11.
 */
function getcookie(objname){//获取指定名称的cookie的值
    var arrstr = document.cookie.split("; ");
    for(var i = 0;i < arrstr.length;i ++){
        var temp = arrstr[i].split("=");
        if(temp[0] == objname) return unescape(temp[1]);
    }
}

function deleteCourse(lid){

    $.ajax({
        url:"/deleteLessons",
        type:'post',
        data:{cookie:getcookie("ocookie"),cid:lid},
        dataType:'json',
        async: false,
        error: function(request) {
            console.log(request);
            alert("Connection error");
        },
        success:function(json){
            console.log(JSON.stringify(json));

        }
    });

}
/**
 * Created by Administrator on 2017/4/14.
 */
