$(function()
{
	$('body').on("mouseover",".contactItem",function()
	{
		$(this).find("span").show();
	});
	
	$('body').on("mouseleave",".contactItem",function()
	{
		$(this).find("span").hide();
	});
	
	$("#searchContact").keyup(function()
	{
		var value = $("#searchContact").val();
//		alert("search "+value);
		
		if(value!="")
		{
			$(".contactItem").hide().each(function()
			{
				if($(this).text().indexOf(value) != -1)
				{
					$(this).parent().parent().addClass("in");
					$(this).show();
				}
			});
			
			var elements = $(".contactItem:visible").length;
//			alert("elements affichés "+elements);
			
			elements == 0 ? $(".groupPanel").hide() : $(".groupPanel").show();
		}
		else
		{
			$(".panel-collapse").removeClass("in");
			$(".groupPanel").show();
		}
	});
	
	$("body").on("click","#displayContact",function()
	{
		$('#cardContainer').show();
		$("#cardContactName").text($(this).parent().parent().text());
	});
	
	$("body").on("click",".card",function()
	{
		var id=1;
		window.location.href = "updateContact.jsp?id="+id;
	});
	
});
