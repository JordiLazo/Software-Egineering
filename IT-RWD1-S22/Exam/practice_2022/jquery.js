function func1(){
    $("#img1").fadeToggle();
}

function func2(){
    //$("div").css("background-color","orange")
    $(".para").css("font-style","italic")
    $("#div1,#div2").css("background-color","green")
    $("div p").fadeToggle();
    $("li:even").fadeToggle();
}

function func3(){
    document.getElementById("img2").style.width="500px";
}
$("button").on(func4);
function func4(){
    $("#img2").css("width","700px")
}