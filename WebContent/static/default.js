//alert("Hello! I am an alert box!!");

//jQuery(document).ready(function () {

//});

//jQuery(window).load

function selectOption(sectorID){
	var optionElement = document.getElementById("option_"+sectorID);
	//var optionElement = $("#option_"+sectorID); // JQUERY WAY
	if(optionElement){
		console.log("WOO I have option element option_"+sectorID);
		optionElement.selected = true;
		//optionElement.attr('selected','selected'); // JQUERY WAY
	}else{
		console.log("BOO I DO NOT have option_"+sectorID);
	}
}

/*
function selectOptions(sectorIDs){
	//setTimeout(function(){	}, 2000);
	console.log("I have sectorIDs amount: " + sectorIDs.length);
	for(var sectorID in sectorIDs){
		//var optionElement = $("option_"+sectorID).selected;
		//console.log("sectorID is " + sectorID);
		var optionElement = document.getElementById("option_"+sectorID);
		if(optionElement){
			console.log("I have option element option_"+sectorID);
//			$("option_"+sectorID).selected = true;
			optionElement.selected = true;
		}else{
			console.log("I DO NOT have option_"+sectorID);
		}

		//$("option_"+sectorID).selected = true;
		//$("option_"+sectorID).attr("selected","selected");
		//$("option_"+sectorID).prop("selected",true);
		//var x = document.getElementById("option_"+sectorID).selected;
		//console.log("selectoptions!!!!!!!!!!!!" + x);
	}
}
*/