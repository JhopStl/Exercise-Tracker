$("button").click(function(){
var count = $("input").length + 1;
 $("form").prepent("<input type='text' value='add set'" + count + "' name='add set" + count + "'><br>");
});