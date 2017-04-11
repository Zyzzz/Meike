/**
 * Created by Administrator on 2017/4/11.
 */
function getcookie(objname){//获取指定名称的cookie的值
    var arrstr = document.cookie.split("; ");
    for(var i = 0;i < arrstr.length;i ++){
        var temp = arrstr[i].split("=");
        if(temp[0] == objname) return unescape(temp[1]);
    }
}

function deleteCourse(cid){

    $.ajax({
        url:"/deleteCourse",
        type:'post',
        data:{cookie:getcookie("ocookie"),cid:cid},
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
