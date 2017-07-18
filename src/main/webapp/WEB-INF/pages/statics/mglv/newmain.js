/* Author:

*/
(function($) {
    
	$.fn.ietextarea = function(options) {
		var settings = {
			
		};
		settings = $.extend(settings , options || {});
		
		return this.each(function(){
                    
			var $this = $(this);
                    if ($this.attr("replaced") == "yes") {
                        return;
                    }
                    //$this.hide();
			var $boltextarea = $('<div class="bleditor" contenteditable="true">' + $this.val() + '</div>');
			$this.after($boltextarea);
			$boltextarea.css({"padding":"10px","width":"90px"});
			$boltextarea.keyup(function(){
				$this.val($boltextarea.html());
			});
                        $this.attr({"replaced":"yes"});
		});
                
	}
})(jQuery);
var winHeight = 0;
var followObjs = [];
function hScroll() {
	addEvent(window, "mousewheel", m, false);
	addEvent(window, "DOMMouseScroll", m, false);
}
function m(e) {
		if (!e) {
			var e = window.event;
		}
		var r = 0;
		if (e.wheelDelta) {
			r = e.wheelDelta;
		} else {
			r = -40 * e.detail;
		}	
		window.scrollBy(-r / 2, 0);
}
function addEvent(el, evt, func) {
	if (el.addEventListener) {
		el.addEventListener(evt, func, false)
	} else {
		el.attachEvent("on" + evt, function(e) {
			func.call(el, e)
		})
	}
}

hScroll();

var wrap_img_idx = 0;
jQuery(document).ready(function($){ 
	$("object").each(function(i){
		bolu_follow_wrap(this);
	});
	
	$(".bolu_follow").each(function(i){
		bolu_follow_wrap(this);
	});
	
	jQuery("img[source]").each(function(i){
		bolu_img_wrap(this);
	});
	
	resize();
	Resize_timer = setInterval(function() {
		resize();
	}, 600);
	
	Follow_Timer = setInterval(function(){bolu_v_layout();},500);
});

var resizeListener = [];
function addResizeListener(func) {
	resizeListener[resizeListener.length] = func;
}
function resize() {
	var tmp = jQuery(window).innerHeight();
	if (tmp != winHeight) {
		winHeight = tmp;
                if(BROWSER.iemode===8){
                    jQuery("#main").css({
			height : (winHeight) + "px"
		});
                }else{
                    jQuery("#main").css({
                            width : (winHeight) + "px"
                    });
                }
                //jQuery(window).scrollTop(0);
                for (var i = 0; i < resizeListener.length; i ++) {
                        resizeListener[i](winHeight);
                }
	}
	
}
function bolu_img_wrap(img) {
	var idx = wrap_img_idx ++;
	var $obj = $(img);
	if(BROWSER.iemode!==8){
                $obj.wrap(function(){
                        return "<span style='display:inline-block; text-align:right;' id='bolu-img-wrap-" + idx + "'></span>";
                });
                $obj.addClass("vimg");
                $obj.on("load",function(event){
                        var w = this.width;
                        var h = this.height;
                        var $wp = jQuery("#bolu-img-wrap-" + idx);
                        $wp.width(h);
                        $wp.height(w);
                });
        }
	
	$obj.attr("src",$obj.attr("source"));
	$obj.removeAttr("source");
}

function bolu_img_wrap_direct(img) {
	var idx = wrap_img_idx ++;
	var $obj = $(img);
	
	$obj.wrap(function(){
		return "<span style='display:inline-block' id='bolu-img-wrap-" + idx + "'></span>";
	});
	$obj.addClass("vimg");
	var w = $obj.width();
	var h = $obj.height();
	var $wp = jQuery("#bolu-img-wrap-" + idx);
	$wp.width(h);
	$wp.height(w);
}


function bolu_follow_wrap(obj) {
	var $vObj = jQuery(obj);
	$vObj.wrap("<span style='display:inline-block' id='bolu-follow-wrap-" + followObjs.length + "'></span>");
	jQuery("<div id='bolu-follow-outer-" + followObjs.length + "' style='position:absolute;'></div>")
		.appendTo("body")
		.css({position:"absolute"})
		.append($vObj);

	followObjs[followObjs.length] = {obj:jQuery("#bolu-follow-wrap-"+followObjs.length),flobj:jQuery("#bolu-follow-outer-" + followObjs.length)};
}

function bolu_v_layout() {
	for(var i=0; i<followObjs.length;i++) {
		var f = followObjs[i];
		var $vObj = f.obj; //wrap flash
		var $flObj = f.flobj; // outer absolute flash
		
		var w = $flObj.width();
		var h = $flObj.height();
		
		if (f["w"] != w && f["h"] != h) {
			$vObj.width(h);
			$vObj.height(w);
			f["w"] = w;
			f["h"] = h;
		}
		
		
		var l = $vObj.offset().left ;
		var t = $vObj.offset().top;
		
		if (f["l"] != l || f["t"] != t) {
			$flObj.offset({left:l,top:t});
			f["l"] = l;
			f["t"] = t;
		}
	}
}

function boljoo_ie_input(input_array){
    if(BROWSER.iemode>=9){
        var length = input_array.length;
        for(var i=0; i<length; i++){
            $obj = $(input_array[i]);
            $obj.css({"direction":"ltr","font-family":"iechagaan","-ms-transform":"rotate(180deg)"});
        }
    }
}

function bolu_insertHTML(textarea , html) {
//    var frame_id = textarea.attr('id')+'_frame';
//    var frame = document.getElementById(frame_id);
    var frame = bolu_getiframe(textarea);
    frame.contentWindow.focus();
    var doc = frame.contentWindow.document;
    var rag = doc.selection.createRange();
    if (rag) {
        var span = rag.pasteHTML(html);
    }
}
function bolu_getiframe(textarea){
    var frame_id = $(textarea).attr('id')+'_frame';
    var frame = document.getElementById(frame_id);
    return frame;
}
function bolu_getiframe_byid(id){
    var frame_id = id+'_frame';
    var frame = document.getElementById(frame_id);
    return frame;
}
function bolu_gethtml(textarea){
    var frame = bolu_getiframe(textarea);
    var doc = frame.contentWindow.document;
    return doc.body.innerHTML;
}
function bolu_gethtml_byid(id){
    var frame = bolu_getiframe_byid(id);
    var doc = frame.contentWindow.document;
    return doc.body.innerHTML;
}
function bolu_cleariframe(textarea){
    var frame = bolu_getiframe(textarea);
    var doc = frame.contentWindow.document;
    doc.body.innerHTML = '';
    $(textarea).val('');
}
/*
 *解决 IE8 以上 input 问题
 */
function ieInput(inputs){
    if(BROWSER.iemode>=9){
        var input = inputs.split("|");
        for(var i = 0; i<input.length; i++){
            var obj = jQuery(input[i]);
            obj.css({'text-align': 'left','font-family': 'iechagaan','direction': 'ltr','-ms-transform':'rotate(180deg)'});
        }
    }
}
/*
 var scrollFunc=function(e){ 
 e=e || window.event; 
 if(e.wheelDelta && event.ctrlKey){//IE/Opera/Chrome 
 event.returnValue=false;
 }else if(e.detail){//Firefox 
 event.returnValue=false; 
  } 
 }  

 if(document.addEventListener){ 
 document.addEventListener('DOMMouseScroll',scrollFunc,false); 
 }
 window.onmousewheel=document.onmousewheel=scrollFunc;
			 
 */
