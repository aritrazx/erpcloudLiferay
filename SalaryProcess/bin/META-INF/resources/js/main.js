/**
 * 
 */

/*------------validation function-----------------*/
var count=0; // to count blank fields
function validation(event){
 //fetching radio button by name
 var radio_check = document.getElementsByName('gender');
 //fetching all inputs with same class name text_field and an html tag textarea
 var input_field = document.getElementsByClassName('text_field');
 var text_area = document.getElementsByTagName('textarea');
 //validating radio button
 if(radio_check[0].checked== false && radio_check[1].checked== false){
 var y = 0;
 }
 else{
 var y = 1;
 }
 //for loop to count blank inputs
 for(var i=input_field.length;i>count;i--){
 if(input_field[i-1].value==''|| text_area.value=='')
 {
 count = count + 1;
 }
 else{
 count = 0;
 }
 }
 //Notifying validation
 if(count!=0||y==0){
 alert("*All Fields are mandatory*");
 event.preventDefault();
 }
 else{
 return true;
 }
}
/*---------------------------------------------------------*/
//Function that executes on click of first next button

//Function that executes on click of first previous button
function prev_step1(){
 document.getElementById("first").style.display="block";
 document.getElementById("second").style.display="none";
 document.getElementById("active1").style.color="red";
 document.getElementById("active2").style.color="gray";
 }
//Function that executes on click of second next button

//Function that executes on click of second previous button
 function prev_step2(){
 document.getElementById("third").style.display="none";
 document.getElementById("second").style.display="block";
 document.getElementById("active2").style.color="red";
 document.getElementById("active3").style.color="gray";
 }