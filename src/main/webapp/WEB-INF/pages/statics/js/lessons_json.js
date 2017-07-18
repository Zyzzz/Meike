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
    //alert(hooyesQueryString("cid"));
    $.ajax({

        url:baseurl+"/getLessonsByCourseId",
        type:'get',
        data: {CourseId:hooyesQueryString("cid")},
        dataType:'json',
        async: false,

        error: function(request) {
            console.log(request);
            alert("Connection error");
        },
        success:function(json){
           // alert("success");console.log(JSON.stringify(json));
            // console.log(json);
            var courses=json.landcviewEntities;
            var pictureEntity = json.pictureEntity;
            var oPictureEntity = json.oPictureEntity;
            var organizationEntity = json.organizationEntity;

            //console.log("length:"+courses.length+"lname:"+courses[0].lname);


            $(".col-md-3").prepend( '<div class="personBox"> <div class="personBox_1"> <div class="person_image"> ' +
                '<img src="'+oPictureEntity.url+'" class="img-responsive" alt=""/></div><div class="person_image_desc"> <h1>'
                +organizationEntity.name
                +'</h1> </div> <div class="clearfix"> </div> </div> <div class="person_description"> <p>'+
                organizationEntity.information+
                '</p> </div> </div>')


            $(".col-md-9").prepend('<img src="'+pictureEntity.url+'" class="img-responsive" alt=""/> <h3>'+courses[0].cname+'</h3>' +
                '<p>' + courses[0].description+'</p>')

           for(var i=0;i<courses.length;i++){
                    $(".table-list").append('<li class="clearfix"> <div class="id_col">'
                        +(i+1)
                        +'</div> <div class="name_col"><a href="lessons_detail.html?lid='+courses[i].lid+'">'
                        +courses[i].lname
                        +'</a></div> <div class="duration_col">'
                        +courses[i].time
                        +' Minute</div> </li>')
                }

        }
    });

});