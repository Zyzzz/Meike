/**
 * Created by cyy on 2017/2/27.
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
        url:"/getAllTeachers",
        type:'post',
        data:{cookie:getcookie("ocookie")},
        dataType:'json',
        async: false,
        error: function(request) {
            console.log(request);
            alert("Connection error");
        },
        success:function(json){
            alert("success");
             console.log(JSON.stringify(json));
            // // console.log(json);
            var teachers=json.teacherEntities;
            console.log(teachers[0])
            // console.log("course_length:"+courses.length);
            //
             for(var i=0;i<teachers.length;i++){
                $("#table1").append('<tr> <td>' +
                    teachers[i].name+'</td> <td>'+
                    teachers[i].phone +'</td> </tr>')
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
