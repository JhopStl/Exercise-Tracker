$("#add-set").click(function(){
var count = $("input").length + 1;
var html =  '<div class="form-group"><label for="reps">Reps</label>' +
'<input type="number" name="rep" id="reps" /><label for="weight">@ Weight</label><input type="text" name="weight" id="weight" /></div>'
// $("form").append("<input type='number' value='add rep'" + count + "' name='rep" + count + "'>");
// $("form").append("<input type='text' value='add weight'" + count + "' name='weight" + count + "'>");
$("form").append(html);

   });