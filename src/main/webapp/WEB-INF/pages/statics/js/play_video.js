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

        url:baseurl+"/getLessonsByLid",
        type:'get',
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
            var url=json.lessonsinformationEntity.url;
            var lessonName=json.lessonsinformationEntity.lname;
            var pictureurl = json.pictureEntity.url;
            var tname = json.lessonsinformationEntity.tname;
            $(".col-md-9").prepend('<h3>&nbsp;'+lessonName+'</h3>'+'<video width="1080" height="540" controls="controls">'+
                '<source src="'+url+'" type="video/mp4" /> </video>');

            $("#personBox").prepend(' <div class="personBox_1"> ' +
                '<div class="person_image">' +
                ' <img src="'+pictureurl+
                 '" class="img-responsive" alt=""/> </div> <div class="person_image_desc"> <h1>' +
                 tname+'</h1> <p>北京 全栈工程师</p> </div> <div class="clearfix"> </div> </div>')
        }
    });

});
