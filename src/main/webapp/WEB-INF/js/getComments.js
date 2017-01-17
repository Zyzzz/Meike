/**
 * Created by Administrator on 2017/1/16.
 */

//评论


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

    $.ajax({
        url:"/getAllComments",
        type:'post',
        data:{cid:hooyesQueryString("cid")},
        dataType:'json',
        async: false,

        error: function(request) {
            console.log(request);
            alert("Connection error");
        },
        success:function(json){
            //alert("success");
            var evaluateviewEntities = json.evaluateviewEntities;
            var picture = json.pictureEntities;
            console.log(JSON.stringify(json));

            console.log(evaluateviewEntities.length);

            $(".comment_section").append('<h4>'+ evaluateviewEntities.length +' Comments</h4> <ul class="comment-list"> </ul></div>');

            for(var i=0;i<evaluateviewEntities.length;i++){
                var timestamp4 = new Date(evaluateviewEntities[i].times);
                $(".comment-list").append('<li> ' +
                    '<div class="author-box"> ' +
                    '<div class="author-box_left"><img src="' + picture[i].url+'" class="img-responsive" alt=""/>' +
                    '</div> <div class="author-box_right">' +
                    '<h5>'+ evaluateviewEntities[i].nickname + '<span class="m_1">'+timestamp4+'</span>' +
                    '<p>' +evaluateviewEntities[i].content+'</p> ' +
                    '</div>' +
                    ' <div class="clearfix"> </div> ' +
                    '</div>' +
                    ' </li> '
                )
            }

        }

    });


});
