/**
 * Created by cyy on 2017/1/15.
 */

$(document).ready(function (){
        alert("courses_json_request");
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
                alert("success");
                console.log(JSON.stringify(json));
                // console.log(json);
                var courses=json.courseInformationEntities;
                console.log("course:"+courses[0].courseEntity.name);
                console.log("course_length:"+courses.length);

                for(var i=1;i<=courses.length;i++){
                    $(".table-list").append('<li class="clearfix"> <div class="id_col">'
                        +i
                        +'</div> <div class="name_col"><a href="course_detail.html">'
                        +courses[i-1].courseEntity.name
                        +'</a></div> <div class="duration_col">'
                        +courses[i-1].courseEntity.type
                        +'</div> <div class="date_col"></div> </li>')
                }

            }

        });

});
