/**
 * Created by Administrator on 2017/1/16.
 */

//评论

$(document).ready(function (){

    $.ajax({
        url:"/getAllCourse",
        type:'post',
        dataType:'json',
        async: false,

        error: function(request) {
            console.log(request);
            alert("Connection error");
        },
        success:function(json){
            //alert("success");
            //console.log(JSON.stringify(json));
            // console.log(json);
            //var courses=json.courseInformationEntities;
            //console.log("course:"+courses[0].courseEntity.name);
            //console.log("course_length:"+courses.length);
            //
            //for(var i=0;i<courses.length;i++){
            //    $(".table-list").append('<li class="clearfix"> <div class="id_col">'
            //        +i
            //        +'</div> <div class="name_col"><a href="course_detail.html?cid='+courses[i].courseEntity.id+'">'
            //        +courses[i].courseEntity.name
            //        +'</a></div> <div class="duration_col">'
            //        +courses[i].courseEntity.type
            //        +'</div> <div class="date_col"></div> </li>')
            //}

        }

    });


});
