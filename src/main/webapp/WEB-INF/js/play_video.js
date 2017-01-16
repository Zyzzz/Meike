/**
 * Created by cyy on 2017/1/16.
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
   // alert(hooyesQueryString("lid"));
    $.ajax({

        url:"/getLessonsByLid",
        type:'post',
        data: {lid:hooyesQueryString("lid")},
        dataType:'json',
        async: false,

        error: function(request) {
            console.log(request);
            alert("Connection error");
        },
        success:function(json){
          //  alert("success");
            console.log(JSON.stringify(json));
            var url=json.url;
            var lessonName=json.lname;
            // console.log(json);
            // var courses=json.landcviewEntities;
            // var courseEntity = json.courseEntity;
            // var pictureEntity = json.pictureEntity;
            //
            // console.log("length:"+courses.length+"lname:"+courses[0].lname);
            //
            $(".col-md-9").prepend('<video width="1080" height="540" controls="controls">'+
                '<source src="'+url+'" type="video/mp4" /> </video>'+'<h3>'+lessonName+'</h3>>')

            //
            // for(var i=0;i<courses.length;i++){
            //     $(".table-list").append('<li class="clearfix"> <div class="id_col">'
            //         +(i+1)
            //         +'</div> <div class="name_col"><a href="lessons_detail.html?lid='+courses[i].lid+'">'
            //         +courses[i].lname
            //         +'</a></div> <div class="duration_col">'
            //         +courses[i].time
            //         +' Minute</div> </li>')
            // }
        }
    });

});
