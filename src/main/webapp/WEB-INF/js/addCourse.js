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
        //alert("user_ajax");

        $.ajax({
            // url:'http://localhost:8080/userLogin',
            url:"/addCourse",
            type:'post',
            dataType:'json',
            async: false,
            data:'cookie='+getcookie('ocookie')+'&'+ $("#courseform").serialize(),
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
                    window.open('O_allcourse?type='+$('#tpye option:selected').text(),'_self');
                }

            }

        });
    });
});

