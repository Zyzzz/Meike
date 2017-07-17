/**
 * Created by Zyzzz on 2017/4/14
 */
function getcookie(objname){//获取指定名称的cookie的值
    var arrstr = document.cookie.split("; ");
    for(var i = 0;i < arrstr.length;i ++){
        var temp = arrstr[i].split("=");
        if(temp[0] == objname) return unescape(temp[1]);
    }
}

function deleteLessons(lid){

    $.ajax({
        url:baseurl+"/deleteLessons",
        type:'get',
        data:{cookie:getcookie("ocookie"),cid:lid},
        dataType:'json',
        async: false,
        error: function(request) {
            console.log(request);
            alert("Connection error");
        },
        success:function(json){
            console.log(JSON.stringify(json));
            location.reload()
        }
    });

}

