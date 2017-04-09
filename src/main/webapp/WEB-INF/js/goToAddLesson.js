/**
 * Created by Administrator on 2017/4/9.
 */


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

$(document).ready(function (){
    $("#addLesson").click(function(){

        window.opener=null;
        window.open('O_addlessons?CourseId='+hooyesQueryString('CourseId'),'_self');
    });

});