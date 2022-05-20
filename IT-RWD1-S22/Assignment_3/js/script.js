//MAKE THE MAGIC HAPPEN


// net moving: DONE BY NURAN AND VALENTINA

$("#net").click(function () {
    $(document).mousemove(function (e) {
        $("#net").css({ left: e.pageX, top: e.pageY });

    });

});



$("#net").hover(function () {

    if ($("#net").css("transform") == "none") {
        $("#net").css("transform", "rotateY(180deg)");
    }

    else {
        $("#net").css("transform", "");
    }

});


//butterfly : DONE BY NURAN AND VALENTINA

$("#butterfly").hover(function () {
    $(this).css({
        left: (Math.random() * 400) + "px",
        top: (Math.random() * 400) + "px",
    });
}
);

//butterfly movement: DONE BY NURAN AND VALENTINA

$(document).ready(function () {
    // Call to function
    $("#butterfly").animate({ left: "+=400" }, "slow", function () { squareMovement(this) });
});

// Declaration of function
function squareMovement(IdRef) {
    $(IdRef).animate({ top: "+=200" }).animate({ left: "+=300" }).animate({ top: "-=100" }).animate({ left: "-=100" }, function () { squareMovement(IdRef); });
}


// delay animate
function squareMovement(IdRef) {
    $(IdRef).delay(3000).animate({ top: "+=200" }).delay(3000).animate({ left: "+=200" }).delay(3000).animate({ top: "-=200" }).delay(3000).animate({ left: "-=200" }, function () { squareMovement(IdRef); });
}


//apple position: DONE BY JORDI

$(document).ready(function () {
    $("#apple1").css("marginLeft", "+=850px");
    $("#apple2").css("marginLeft", "+=1050px");
    $("#apple3").css("marginLeft", "+=950px");
    $("#apple3").css("marginTop", "+=50px");


});

$(document).ready(function () {
    $(".apple").css("z-index", "1");


});

$(document).ready(function () {
    $("#basketfront").css("z-index", "2");


});

//apple in the basket: DONE BY NURAN AND VALENTINA

$("#apple1").click(function () {

    $("#apple1").animate({
        left: "-450px",
        top: "475px",
    }, 2000);

});


$("#apple2").click(function () {
    $("#apple2").animate({
        left: "-750px",
        top: "475px",
    }, 2000);
});

$("#apple3").click(function () {

    $("#apple3").animate({
        left: "-600px",
        top: "450px",
    }, 2000);

});


//apple wiggle: DONE BY SANA

$("#apple1").click(function () {
    $("#apple1").css('transform', 'rotate(' + -30 + 'deg)');
});

$("#apple2").click(function () {
    $("#apple2").css('transform', 'rotate(' + -30 + 'deg)');
});

$("#apple3").click(function () {
    $("#apple3").css('transform', 'rotate(' + -30 + 'deg)');
});



//watering can: DONE BY SANA

$("#wateringcan").click(function () {
    $("#wateringcan").css('transform', 'rotate(' + -45 + 'deg)');
});

$("#wateringcan").click(function () {
    $(document).mousemove(function (c) {
        $("#wateringcan").css({ left: c.pageX, top: c.pageY });

    });

});


//water drop: DONE BY SANA

$(document).ready(function () {
    $(".waterdrop").css("marginLeft", "-30px");
    $(".waterdrop").css("marginTop", "270px");
    $(".waterdrop").css("display", "none");

});

$("#wateringcan").click(function () {
    $(".waterdrop").css('transform', 'rotate(' + 30 + 'deg)');
    $(".waterdrop").css("display", "block")
});

//waterdrop move with can: DONE BY JORDI

$("#wateringcan").click(function () {
    $(document).mousemove(function (e) {
        $(".waterdrop").css({ left: e.pageX, top: e.pageY });

    });

});


//water drop animation: DONE BY JORDI
$("#wateringcan").click(function () {
    // Call to function
    $(".waterdrop").animate({ left: "+=0" }, "slow", function () { waterdrop(this) });
});

// Declaration of function
function waterdrop(water) {
    $(water).fadeIn().animate({ top: "+=200" }).fadeOut().animate({ top: "-=200" }).fadeIn().animate({ top: "+=200" }).fadeOut().animate({ top: "-=200" }, function () { waterdrop(water); });
}

//night mode toggle: DONE BY SANA

$(".night").click(function(){
if ($("body").hasClass("nightmode")){
    $("body").removeClass("nightmode");
    $(".night").text("off");
}else{
    $("body").addClass("nightmode");
    $(".night").text("ON");
}

});


