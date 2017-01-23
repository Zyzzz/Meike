/**
 * Created by Zyzzz on 2017/1/23.
 */






$(document).ready(function (){

    $.ajax({
        url:"/getCourseByOcookie",
        type:'post',
        data:{cookie:getcookie("ocookie")},
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

            //$(".comment_section").append('<h4>'+ evaluateviewEntities.length +' Comments</h4> <ul class="comment-list"> </ul></div>');
            //
            //for(var i=0;i<evaluateviewEntities.length;i++){
            //    var timestamp4 = new Date(evaluateviewEntities[i].times);
            //    $(".comment-list").append('<li> ' +
            //        '<div class="author-box"> ' +
            //        '<div class="author-box_left"><img src="' + picture[i].url+'" class="img-responsive" alt=""/>' +
            //        '</div> <div class="author-box_right">' +
            //        '<h5>'+ evaluateviewEntities[i].nickname + '<span class="m_1">'+timestamp4+'</span>' +
            //        '<p>' +evaluateviewEntities[i].content+'</p> ' +
            //        '</div>' +
            //        ' <div class="clearfix"> </div> ' +
            //        '</div>' +
            //        ' </li> '
            //    )
            //}

        }
    });

});
