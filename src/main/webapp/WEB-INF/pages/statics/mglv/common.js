/**
 * @author Administrator
 */

var BROWSER = {};
var USERAGENT = navigator.userAgent.toLowerCase();
browserVersion({'ie':'msie','firefox':'','chrome':'','opera':'','safari':'','mozilla':'','webkit':'','maxthon':'','qq':'qqbrowser'});
if(BROWSER.safari) {
	BROWSER.firefox = true;
}
BROWSER.opera = BROWSER.opera ? opera.version() : 0;

HTMLNODE = document.getElementsByTagName('head')[0].parentNode;
if(BROWSER.ie) {
	BROWSER.iemode = parseInt(typeof document.documentMode != 'undefined' ? document.documentMode : BROWSER.ie);
	HTMLNODE.className = 'ie_all ie' + BROWSER.iemode;
} else {
	HTMLNODE.className = 'ff';
}


function browserVersion(types) {
	var other = 1;
	for(i in types) {
		var v = types[i] ? types[i] : i;
		if(USERAGENT.indexOf(v) != -1) {
			var re = new RegExp(v + '(\\/|\\s)([\\d\\.]+)', 'ig');
			var matches = re.exec(USERAGENT);
			var ver = matches != null ? matches[2] : 0;
			other = ver !== 0 && v != 'mozilla' ? 0 : other;
		}else {
			var ver = 0;
		}
		eval('BROWSER.' + i + '= ver');
	}
	BROWSER.other = other;
}

function boljoo_ie_input_wrap(input,br,lateX){
    
        if(BROWSER.iemode>=9){
            var idx = wrap_img_idx ++;

            var $obj = $(input);
            
            if(lateX==2){
                    $obj.wrap(function(){
                            return "<div name='bichil_error_in_ie_tab' style='-ms-transform-origin:right top;-ms-transform:rotate(90deg) translateX(50%);position: absolute;' id='bolu-img-wrap-" + idx + "'></div>";
                    });
            }else{
                    $obj.wrap(function(){
                            return "<div name='bichil_error_in_ie_tab' style='-ms-transform-origin:right top;-ms-transform:rotate(90deg) translateX(100%);position: absolute;' id='bolu-img-wrap-" + idx + "'></div>";
                    });
            }
            //$obj.addClass("mglinput");
            $obj.css({'font-family':'ieinputchagaan','writing-mode':'tb-rl','text-align':'left'});
           
            var $wp = jQuery("#bolu-img-wrap-" + idx);
            var $pare = $wp.parent($wp);
           
            if(br==1){
                    $wp.after("<br></br>");
            }else if(br==2){
                    $pare.after("<br></br>");
            }else if(br==3){
                    $wp.before("<br></br>");
                    $wp.after("<br></br>");
            }
        }

}
