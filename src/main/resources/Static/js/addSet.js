var count=1;
function create() {
count++;
document.getElementById('addSet').innerHTML+='<br/><input type="text" id="'+count+'" placeholder="Input Field'+count+'"  /><br/>';
e.prventDefault();}