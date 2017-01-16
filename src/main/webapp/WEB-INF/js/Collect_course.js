/**
 * Created by cyy on 2017/1/16.
 */

function getcookie(objname){//获取指定名称的cookie的值
    var arrstr = document.cookie.split("; ");
    for(var i = 0;i < arrstr.length;i ++){
        var temp = arrstr[i].split("=");
        if(temp[0] == objname) return unescape(temp[1]);
    }
}

function hooyesQueryString(queryStringName)
{
    var returnValue="";
    var URLString=new String(document.location);
    var serachLocation=-1;
    var queryStringLength=queryStringName.length;
    do
    {
        serachLocation=URLString.indexOf(queryStringName+"\=");
        if (serachLocation!=-1)
        {
            if ((URLString.charAt(serachLocation-1)=='?') || (URLString.charAt(serachLocation-1)=='&'))
            {
                URLString=URLString.substr(serachLocation);
                break;
            }
            URLString=URLString.substr(serachLocation+queryStringLength+1);
        }

    }
    while (serachLocation!=-1)
    if (serachLocation!=-1)
    {
        var seperatorLocation=URLString.indexOf("&");
        if (seperatorLocation==-1)
        {
            returnValue=URLString.substr(queryStringLength+1);
        }
        else
        {
            returnValue=URLString.substring(queryStringLength+1,seperatorLocation);
        }
    }
    return returnValue;
}

function collect() {
    alert(getcookie("cookie"));
    $.ajax({
        // url:'http://localhost:8080/userLogin',
        url:"/CollectCourse",
        type:'post',
        data:{courseID:hooyesQueryString("cid"),cookie:getcookie("cookie")},
        dataType:'json',
        async: true,
        error: function(request) {
            console.log(request);

            alert("Connection error");
        },
        success:function(json){

            console.log(JSON.stringify(json));

            window.json_all=JSON.stringify(json);
            alert("window.json_all"+window.json_all);
            var status=json.status;
            if (status!=0){
                alert(json.result)
            }

        }
    });
}