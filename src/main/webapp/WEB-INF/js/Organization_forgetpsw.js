/**
 * Created by Zyzzz on 2017/1/23.
 */



$(document).ready(function (){
    $("#changePsw").click(function(){
        var changepsw ={
            verifyCode:$("#verifyCode").val(),
            email:$("#email").val(),
            newpassword:$("#newpassword").val()
        }
        alert("user_ajax");
        $.ajax({
            // url:'http://localhost:8080/userLogin',
            url:"/Change_Password",
            type:'post',
            dataType:'json',
            async: false,
            data:changepsw,
            error: function(request,json) {
                console.log(JSON.stringify(json));
                console.log(request);
                alert("Connection error");
            },
            success:function(json){
                console.log(JSON.stringify(json));
                window.json_all=JSON.stringify(json);
                // alert("window.json_all"+window.json_all);
                var status=json.status;
            }

        });
    });
    $("#sendEmail").click(function(){
        var email = {
            email:$("#email").val(),
        };
        $.ajax({
            url:'/O_sendEmail',
            data:email,
            type:'post',
            dataType:'json',
            async: false,
            error: function(request) {
                console.log(request);
                alert("Connection error");
            },
            success:function(json){

                console.log(JSON.stringify(json));

                window.json_all=JSON.stringify(json);
                // alert("window.json_all"+window.json_all);
                var status=json.status;
            }

        })
    }),
        function autoTime(){
            localStorage.WaitTime--;
            if(localStorage.WaitTime<=0)
            {
                $('#verificationClick').removeClass('disabled');
                $('#verificationClick').html("获取验证码") ;
            }else{
                if($('#verificationClick').text()=="获取验证码")
                    return;
                $('#verificationClick').addClass('disabled');
                $('#verificationClick').html("获取验证码("+localStorage.WaitTime+")") ;
                setTimeout("autoTime()",1000);
            }
        }});