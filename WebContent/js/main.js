$(function()
		{
			var focusedOnce = false;

			var errorType = $('#errorMessage').attr("data-type");
			
			if(errorType == "contactExists")
				$("#nom, #prenom").css("border-color","#a94442").css("box-shadow","0px 0px 10px #a94442");
			else if(errorType == "createEmptyField")
				$("#nom, #prenom, #email").css("border-color","#a94442").css("box-shadow","0px 0px 10px #a94442");
			else if(errorType == "updateEmptyField")
				$("#nom, #prenom, #email, #idContact").css("border-color","#a94442").css("box-shadow","0px 0px 10px #a94442");
			else if(errorType == "contactDoesnotExists")
				$("#id").css("border-color","#a94442").css("box-shadow","0px 0px 10px #a94442");
			else if(errorType == "loginMismatch" || errorType == "emptyLogin")
				$("#nom, #password").css("border-color","#a94442").css("box-shadow","0px 0px 10px #a94442");
			else if(errorType == "noRecord" || errorType=="searchEmptyField")
				$("#value").css("border-color","#a94442").css("box-shadow","0px 0px 10px #a94442");
			else if(errorType == "contactAlreadyExists")
				$("#nom, #prenom").css("border-color","#a94442").css("box-shadow","0px 0px 10px #a94442");
			
			$("#nom, #prenom, #email, #password,#idContact").focus(function(e)
			{
				$(e.target).css("border-color","#5bc0de").css("box-shadow","0px 0px 10px #5bc0de");
			});
			
			$("#nom, #prenom, #email, #password,#idContact").focusout(function(e)
			{
				$(e.target).css("border-color","#5bc0de").css("box-shadow","0px 0px 0px #FFF").css("border","1px solid #ccc");
			});
			
			$("#logout").click(function()
			{
				alert("logout");
				$.get("Logout");
			});
			
			$("body").on("click","#deleteRow",function()
			{
				$.post("Delete",
				{
					id:$("#rowId").text()
				});
			});
			
			$("#edit").click(function()
			{
				window.location.href = "updateContact.jsp?idContact="+$("#resultId").text();
			});
			
			if($("#resultNom").text() != "")
				$(".table").show();
		});