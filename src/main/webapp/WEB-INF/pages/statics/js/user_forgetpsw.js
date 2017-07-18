/**
 * Created by IMUDGES on 2017/1/16.
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
            url:baseurl+"/ChangePasw",
            type:'get',
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
            url:'/sendEmail',
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
                            alert("window.json_all"+window.json_all);
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
// Verification: function ($scope,phone) {
//     var deferred = $q.defer();
//     var promise = deferred.promise;
//     //ajax请求
//     $http.jsonp(URL1+"getCheckCode.action?phoneNum=" + phone  + URL2)
//     //*******************************************
//         .success(function (response) {
//             if (response.status == 1) {
//                 localStorage.WaitTime=90;
//                 $('#verificationClick').html("获取验证码(90)")
//                 $('#verificationClick').addClass('disabled');
//                 autoTime();
//                 deferred.resolve('register successfully');
//             } else {
//                 if(response.time!=-1)
//                 {
//                     $('#verificationClick').html("处理中...")
//                     localStorage.WaitTime=response.time;
//                     autoTime();
//                 }
//                 localStorage.result=response.result;
//                 deferred.reject('Wrong register info.');
//             }
//         });
//     promise.success = function (fn) {
//         promise.then(fn);
//         return promise;
//     }
//     promise.error = function (fn) {
//         promise.then(null, fn);
//         return promise;
//     }
//     return promise;
// };

