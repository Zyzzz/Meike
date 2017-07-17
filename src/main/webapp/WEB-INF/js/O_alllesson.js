/**
 * Created by cyy on 2017/3/9.
 */

// http://localhost:8000/O_allcourse?type=程序猿
function getcookie(objname){//获取指定名称的cookie的值
    var arrstr = document.cookie.split("; ");
    for(var i = 0;i < arrstr.length;i ++){
        var temp = arrstr[i].split("=");
        if(temp[0] == objname) return unescape(temp[1]);
    }
}

function hooyesQueryString(queryStringName)
{
    var returnValue="";
    var URLString=new String(document.location);
    var serachLocation=-1;
    var queryStringLength=queryStringName.length;
    do
    {
        serachLocation=URLString.indexOf(queryStringName+"\=");
        if (serachLocation!=-1)
        {
            if ((URLString.charAt(serachLocation-1)=='?') || (URLString.charAt(serachLocation-1)=='&'))
            {
                URLString=URLString.substr(serachLocation);
                break;
            }
            URLString=URLString.substr(serachLocation+queryStringLength+1);
        }

    }
    while (serachLocation!=-1)
    if (serachLocation!=-1)
    {
        var seperatorLocation=URLString.indexOf("&");
        if (seperatorLocation==-1)
        {
            returnValue=URLString.substr(queryStringLength+1);
        }
        else
        {
            returnValue=URLString.substring(queryStringLength+1,seperatorLocation);
        }
    }
    return returnValue;
}


$(document).ready(function (){
    //alert("courses_json_request");
    //console.log(a.toString());
    $.ajax({
        url:baseurl+"/getLessonsByCourseId",
        type:'get',
        data:{CourseId:hooyesQueryString("CourseId")},
        dataType:'json',
        async: false,
        error: function(request) {
            console.log(request);
            alert("Connection error");
        },
        success:function(json){
            // alert("success");
            console.log("json:all_lesson:"+JSON.stringify(json));
            // console.log(json);
            var type=json;
            // console.log(type);
            // console.log("course_length:"+courses.length);
            //
            // alert(type.landcviewEntities.length);
            for(var i=0;i<type.landcviewEntities.length;i++) {
                // alert("test");
                $("#Otable").append('<tr>' +
                    ' <td>' + type.landcviewEntities[i].lid + '</td> ' +

                    ' <td>' + type.landcviewEntities[i].lname + '</td>'+
                    ' <td>' + type.landcviewEntities[i].time + '</td> ' +

                    '<td> ' +
                    ' <a href="user.html"><i class="icon-pencil"></i></a>' +
                    ' <a href="#myModal" role="button" data-toggle="modal"><i class="icon-remove"></i></a>' +
                    '</td></tr>'
                )

                // <tr>
                // <td>1</td>
                // <td>Mark</td>
                //
                // <td>
                // <a href="user.html"><i class="icon-pencil"></i></a>
                //     <a href="#myModal" role="button" data-toggle="modal"><i class="icon-remove"></i></a>
                //     </td>
                //     </tr>
            }
        }
    });
});

