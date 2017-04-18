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
    var a = decodeURI(hooyesQueryString("type"));
    $.ajax({
        url:"/getOCourseByType",
        type:'post',
        data:{cookie:getcookie("ocookie"),Type:a},
        dataType:'json',
        async: false,
        error: function(request) {
            console.log(request);
            alert("Connection error");
        },
        success:function(json){
            console.log(JSON.stringify(json));
            var type=json;
            for(var i=0;i<type.length;i++) {

                $("#O_allcourse_type").append('<tr>' +
                    ' <td>' + type[i].id + '</td> ' +

                    ' <td>' +
                    '<a href="/O_alllessons?CourseId=' + type[i].id + '">' +
                    type[i].name
                    + '</a></td>'+
                    ' <td>' + type[i]. lessonNumber+ '</td> ' +
                    ' <td>' + type[i]. description+ '</td> ' +
                    '<td> ' +
                    '<a href="user.html"><i class="icon-pencil"></i></a>' +
                    ' <a href="javascript:;" onclick="deleteCourse('+type[i].id+')"><i class="icon-remove"></i></a>' +
                    '</td></tr>'
                )

            }
        }
    });
});

