/**
 * Created by 隐 on 2016/12/18.
 */

$(document).ready(function (){
   $("#user_login_ajax").submit(function(){
       alert("user_ajax");
       $.ajax({
           url:'http://localhost:7979/userLogin',
           type:'post',
           dataType:'json',
           async: false,
           data:$("#user_login_ajax").serialize(),
           error: function(request) {
               console.log(request);
               alert("Connection error");
           },
           success:function(json){

               alert(JSON.stringify(json));

               var status=json.status;
               if(status=='0'){
                   window.opener=null;
                   window.open('index.html','_self');
               }else{
                   var error=document.getElementsByClassName("error");
                   if(status=="100"){
                       //window.location.href="login.html";
                       error[0].style.display="block";

                   }else{
                       if(status=="101"){

                           //window.location.href="login.html";
                           error[1].style.display="block";

                       }
                   }


               }

           }

       });
   });
});
