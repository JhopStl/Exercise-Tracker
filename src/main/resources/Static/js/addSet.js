$("button").click(function(){
var count = $("input").length + 1;
 $("form").prepend("<input type='number' value='add rep'" + count + "' name='rep" + count + "'>");
 $("form").prepend("<input type='text' value='add weight'" + count + "' name='weight" + count + "'>");
});