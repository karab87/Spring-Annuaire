$(function(){
	
	$(".parent").bind("click",function(){
		$(".montre").show();
	});
	
	
	$(".simple").bind("click",function(){
		$(".montre , #directionparent").hide();
	});
	
	$("#autonome, #general").bind("click",function(){
		$(" #directionparent").hide();
	});
	
	
	$("#directionfils").bind("click",function(){
		$("#directionparent").show();
	});
	
	
	$("#dir").clone();
	
	
	$("#double").bind("click",function(){
		elmt = $("#dir").clone();
		$("#dir").after(elmt);
		$("#nom").text("");
		});
	
	
	$("#avance").bind("click",function(){
		$(".avance").hide()
		
	});
	
	
	
});

