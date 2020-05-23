

$(document).ready(function(){
	
	sessionStorage.clear();
	
	$("#errorbanner").hide();

	$("#form").submit(function(event){
		
		$("#errorbanner").hide();
		$("#successbanner").hide();
		
		event.preventDefault();
		
		var Name = $("#Name").val();
		var Password = $("#Password").val();

		//Si jamais le formulaire n'est pas compètement rempli
		if(Name == "" || Password == ""){
			error = "Please fully complete the form";
			$("#error").text(error);
			$("#errorbanner").show();
		}
		else {
			$.ajax({
			  url:"/UserService/user/" + Name + "/" + Password,
			  type:"GET",
			  async: false,
			  success: function( data ){
				  if(data != "") {
					  
					 sessionStorage.setItem("Name", data);
					 window.location.href = "/card.html";
					 
					  
				  }
				  else {
					  $("#error").text("Wrong name or password");
					  $("#errorbanner").css("margin", "0");
					  $("#errorbanner").show();
					  
				  }
			  }
			})
			
		}		
		
	});
	

	
	
});