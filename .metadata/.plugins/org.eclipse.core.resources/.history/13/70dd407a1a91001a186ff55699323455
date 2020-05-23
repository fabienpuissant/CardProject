

$(document).ready(function(){
	
$("#errorbanner").hide();
$("#successbanner").hide();

$("#form").submit(function(event){
	
	$("#errorbanner").hide();
	$("#successbanner").hide();
	
	event.preventDefault();
	var error = "";
	
	var Name = $("#Name").val();
	var Surname = $("#Surname").val();
	var Password = $("#Password").val();
	var RepeatPassword = $("#RepeatPassword").val()

	//Si jamais le formulaire n'est pas compètement rempli
	if(Name == "" || Surname == "" || Password == "" || RepeatPassword == ""){
		error = "Please fully complete the form";
		$("#error").text(error);
		$("#errorbanner").show();
	}
	else if (Password != RepeatPassword){
		error = "Passwords don't match";
		$("#error").text(error);
		$("#errorbanner").show();
	}
	else {
		//Si le formulaire est complètement rempli, on peut faire un appel ajax vers le serveur afin qu'il ajoute l'utilisateur
		
		var json = {"name": Name, "surname": Surname, "password": Password};
		$.ajax({
		  url:"/UserService/addUser",
		  type:"POST",
		  data:JSON.stringify(json),
		  contentType:"application/json; charset=utf-8",
		  dataType:"json",
		  success: function( data ){
			  if(data) {
				  $("#successbanner").show();
				  $('#form')[0].reset();
			  }
			  else {
				  $("#error").text("Name already taken");
				  $("#errorbanner").css("margin", "0");
				  $("#errorbanner").show();
				  
			  }
		  }
		})
		
	}	
});
	
	
});
	







