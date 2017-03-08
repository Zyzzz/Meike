/**
 * Created by Administrator on 2017/3/8.
 */


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
    $.ajax({
        url:"/getCourseByName",
        type:'post',
        dataType:'json',
        data:{name:hooyesQueryString("name")},
        async: false,
        error: function(request) {
            console.log(request);
            alert("Connection error");
        },
        success:function(json){
            //alert("success");
            console.log(JSON.stringify(json));
            // console.log(json);
            var courses=json
            for(var i=0;i<courses.length;i++){
                $(".table-list").append('<li class="clearfix"> <div class="id_col">'
                    +i
                    +'</div> <div class="name_col"><a href="course_detail.html?cid='+courses[i].id+'">'
                    +courses[i].name
                    +'</a></div> <div class="duration_col">'
                    +courses[i].type
                    +'</div> <div class="date_col"></div> </li>')
            }
        }
    });

});
