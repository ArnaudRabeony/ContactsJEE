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
		alert("search "+$("#searchContact").val());
	});
	
	$("body").on("click","#displayContact",function()
	{
		$('#cardContainer').show();
		$("#cardContactName").text($(this).parent().parent().text());
	});
});
