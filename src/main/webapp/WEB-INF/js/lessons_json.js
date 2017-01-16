/**
 * Created by Zyzzz on 2017/1/16.
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
    alert(hooyesQueryString("cid"));
    $.ajax({

        url:"/getLessonsByCourseId",
        type:'post',
        data: {CourseId:hooyesQueryString("cid")},
        dataType:'json',
        async: false,

        error: function(request) {
            console.log(request);
            alert("Connection error");
        },
        success:function(json){
            alert("success");
            console.log(JSON.stringify(json));
            // console.log(json);
            var courses=json.landcviewEntities;
            var courseEntity = json.courseEntity;
            var pictureEntity = json.pictureEntity;

            console.log("length:"+courses.length+"lname:"+courses[0].lname);

            $(".col-md-9").prepend('<img src="'+pictureEntity.url+'" class="img-responsive" alt=""/> <h3>'+courseEntity.name+'</h3>')

           for(var i=0;i<courses.length;i++){
                    $(".table-list").append('<li class="clearfix"> <div class="id_col">'
                        +(i+1)
                        +'</div> <div class="name_col"><a href="lessons_detail.html?lid='+courses[i].lid+'">'
                        +courses[i].lname
                        +'</a></div> <div class="duration_col">'
                        +""
                        +'</div> </li>')
                }
        }
    });

});