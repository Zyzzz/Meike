/**
 * Created by cyy on 2017/1/15.
 */

$(document).ready(function (){
        //alert("courses_json_request");
        $.ajax({

            url:baseurl+"/getAllCourse",
            type:'get',
            dataType:'json',
            async: false,
            error: function(request) {
                console.log(request);
                alert("Connection error");
            },
            success:function(json){
                //alert("success");
                console.log(JSON.stringify(json));
                // console.log(json);
                var courses=json.courseInformationEntities;
                console.log("course:"+courses[0].courseEntity.name);
                console.log("course_length:"+courses.length);

                for(var i=0;i<courses.length;i++){
                    $(".table-list").append('<li class="clearfix"> <div class="id_col">'
                        +i
                        +'</div> <div class="name_col"><a href="course_detail.html?cid='+courses[i].courseEntity.id+'">'
                        +courses[i].courseEntity.name
                        +'</a></div> <div class="duration_col">'
                        +courses[i].courseEntity.type
                        +'</div> <div class="date_col"></div> </li>')
                }

                for(var j=0;j<courses.length;j++){
                    $(".posts").append('<h3>最新课程</h3> <li>'
                        +'<article class="entry-item">'
                        +'<div class="entry-thumb pull-left">'
                        +'<img src='+courses[j].pictureEntity.url+' class="img-responsive" alt=""/>'
                        +'</div>'
                        +'<div class="entry-content">'
                       +'<h6><a href="#">' +
                        courses[j].courseEntity.name +
                        '</a></h6>'
                        +'<p><a href="#">'
                        +courses[j].courseEntity.type
                        + '</a> &nbsp;/&nbsp; 30 Dec 2015</p>'
                    +'</div>'
                    +'<div class="clearfix"> </div>'
                     +'</article> </li>'
                    )
                }
            }
        });

});
