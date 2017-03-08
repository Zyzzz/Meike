/**
 * Created by Zyzzz on 2017/1/18.
 */


$(document).ready(function (){
    $("#submit").click(function(){
        alert("user_ajax");
        $.ajax({
            // url:'http://localhost:8080/userLogin',
            url:"/Ologin",
            type:'post',
            dataType:'json',
            async: false,
            data:$("#organization_login").serialize(),
            error: function(request) {
                console.log(request);
                alert("Connection error");
            },
            success:function(json){
                console.log(JSON.stringify(json));
                window.json_all=JSON.stringify(json);
                alert("window.json_all"+window.json_all);
                var status=json.status;
                document.cookie="ocookie"+"="+json.cookie+";";
                if(status=='0'){
                   // window.location.href = "admin/index.action";    //跳转到后台主页
                   document.cookie= "oname" +"="+json.name+";";

                   window.opener=null;
                   window.open('O_index.html','_self');
                   console.log("organizationLogin:"+document.cookie);
                }
                //else{
                //    var error=document.getElementsByClassName("error");
                //    if(status=="100"){
                //        window.opener=null;
                //        window.open('login.html','_self');
                //
                //        error[0].style.display="block";
                //    }else{
                //        if(status=="101"){
                //            window.opener=null;
                //            window.open('login.html','_self');
                //            error[1].style.display="block";
                //        }
                //    }

                //}

            }

        });
    });
});

