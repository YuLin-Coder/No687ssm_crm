$(function() {

$("#custypename").blur(
		function() {
			$("#custypename_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#custypename").after("<span id='custypename_msg' style='color: red'>类型名称不能为空</span>");
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
var custypename = $("#custypename").val();
var details = $("#details").val();
$("#custypename_msg").empty();
$("#details_msg").empty();
if (custypename == "" || custypename == null) {
	$("#custypename").after("<span id='custypename_msg' style='color: red'>类型名称不能为空</span>");
	return false;
}
if (details == "" || details == null) {
	$("#details").after("<span id='details_msg' style='color: red'>详情不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#custypename_msg").empty();
$("#details_msg").empty();
});

});
