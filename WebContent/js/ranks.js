$(function() {

$("#ranksname").blur(
		function() {
			$("#ranksname_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#ranksname").after("<span id='ranksname_msg' style='color: red'>等级名称不能为空</span>");
			}
	});

$("#details").blur(
		function() {
			$("#details_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#details").after("<span id='details_msg' style='color: red'>详情不能为空</span>");
			}
	});







$('#sub').click(function(){
var ranksname = $("#ranksname").val();
var details = $("#details").val();
$("#ranksname_msg").empty();
$("#details_msg").empty();
if (ranksname == "" || ranksname == null) {
	$("#ranksname").after("<span id='ranksname_msg' style='color: red'>等级名称不能为空</span>");
	return false;
}
if (details == "" || details == null) {
	$("#details").after("<span id='details_msg' style='color: red'>详情不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#ranksname_msg").empty();
$("#details_msg").empty();
});

});
