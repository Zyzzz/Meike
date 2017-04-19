/**
 * Created by Administrator on 2017/4/10.
 */


function getcookie(objname){//获取指定名称的cookie的值
    var arrstr = document.cookie.split("; ");
    for(var i = 0;i < arrstr.length;i ++){
        var temp = arrstr[i].split("=");
        if(temp[0] == objname) return unescape(temp[1]);
    }
}


$(document).ready(function (){
    $("#save").click(function(){
        alert($("#courseform").serialize());



        var formData = new FormData();
        formData.append("picture", document.getElementById("picture").files[0]);
        formData.append("cname", document.getElementById("cname").text());
        var text = $('#coursetpye option:selected').text()
        formData.append("coursetpye", text);
        formData.append("description", document.getElementById("description").text());
        $.ajax({
            // url:'http://localhost:8080/userLogin',
            url:"/addCourse",
            type:'post',
            async: false,
            processData:false,
            contentType:false,
            data:formData,
            error: function(request) {
                console.log(request);
                alert("Connection error");
            },
            success:function(json){
                console.log(JSON.stringify(json));
                window.json_all=JSON.stringify(json);
                // alert("window.json_all"+window.json_all);
                var status=json.status;
                if(status=='0'){
                    // window.location.href = "admin/index.action";    //跳转到后台主页
                    window.opener=null;
                    window.open('O_allcourse?type='+$('#coursetpye option:selected').text(),'_self');
                }

            }

        });
    });
});

