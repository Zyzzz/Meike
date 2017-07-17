/**
 * Created by cyy on 2017/4/17.
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
        alert($("#tab").serialize());
        var a= 'cookie='+getcookie('ocookie')+'&'+ $("#tab").serialize()
        $.ajax({
            // url:'http://localhost:8080/userLogin',
            url:baseurl+"/Add_teacher",
            type:'post',
            dataType:'json',
            async: false,
            data:a,
            error: function(request) {
                console.log(request);
                alert("Connection error");
            },
            success:function(json){

                console.log(JSON.stringify(json));
                window.json_all=JSON.stringify(json);
                var status=json.status;
                if(status=='0'){
                    var formData = new FormData();
                    var id=json.id;
                    formData.append("tid",id)
                    formData.append("picture", document.getElementById("picture").files[0]);
                    $.ajax({
                        url:baseurl+"/uploadPicture",
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
                            var status=json.status;
                            if(status=='0'){
                                // window.location.href = "admin/index.action";    //跳转到后台主页
                                //window.opener=null;
                                //window.open('O_t?type='+$('#coursetpye option:selected').text(),'_self');
                            }
                        }
                    });
                }
            }
        });
    });
});
