
/**
 * Created by 隐 on 2016/12/18.
 */

$(document).ready(function (){
    $("#submit").click(function(){

        // alert("submit");
        var IsRight=insertManager();
        // alert("IsRight:"+IsRight);
        if(IsRight){

            // alert("user_ajax");
            $.ajax({
                // url:'http://localhost:8080/userLogin',
                url:baseurl+"/user_register",
                type:'get',
                dataType:'json',
                async: false,
                data:$("#user_register_ajax").serialize(),
                error: function(request) {
                    console.log(request);
                    alert("Connection error");
                },
                success:function(json){

                    // alert(JSON.stringify(json));

                    var status=json.status;
                    if(status=='0'){
                        // window.location.href = "admin/index.action";    //跳转到后台主页
                        // alert("success");
                        window.opener=null;
                        window.open('login.html','_self');

                    }else{
                        var error=document.getElementsByClassName("error");
                        // if(status=="100"){
                        //     window.opener=null;
                        //     window.open('register.html','_self');
                        //
                        //     error[0].style.display="block";
                        //
                        // }else{
                        //     if(status=="101"){
                        //
                        //         window.opener=null;
                        //         window.open('register.html','_self');
                        //
                        //         error[1].style.display="block";
                        //
                        //     }
                        // }
                        alert("注册失败");

                        window.opener=null;
                        window.open('register.html','_self');


                    }

                }

            });
        }

    });
    function insertManager() {
        var password = document.getElementById("password").value;
        var repassword = document.getElementById("repsword").value;
        console.log(password);
        console.log(repassword);
        alert("insertManager");
        if(password == ''){
            alert('密码不能为空');
            return false;
        }
        if(password != repassword) {
            alert("两次密码不同，请重新输入");
            return false;
        }
        return true;
    };
});

