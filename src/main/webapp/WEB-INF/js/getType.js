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

$(document).ready(function (){
    //alert("courses_json_request");
    $.ajax({
        url:baseurl+"/getAllType",
        type:'get',
        data:{cookie:getcookie("ocookie")},
        dataType:'json',
        async: false,
        error: function(request) {
            console.log(request);
            alert("Connection error");
        },
        success:function(json){
            // alert("success");
            console.log(JSON.stringify(json));
            // // console.log(json);
            var type=json;
            console.log(type)
            // console.log("course_length:"+courses.length);
            //
            for(var i=0;i<type.length;i++){
                $("#table2").append('<tr> <td>' +
                    type[i]+'</td> </tr>')
                //         +i
                //         +'</div> <div class="name_col"><a href="course_detail.html?cid='+courses[i].courseEntity.id+'">'
                //         +courses[i].courseEntity.name
                //         +'</a></div> <div class="duration_col">'
                //         +courses[i].courseEntity.type
                //         +'</div> <div class="date_col"></div> </li>')
            }
        }
    });
});
