$(function() {

$("#procatename").blur(
		function() {
			$("#procatename_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#procatename").after("<span id='procatename_msg' style='color: red'>类型名称不能为空</span>");
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
var procatename = $("#procatename").val();
var details = $("#details").val();
$("#procatename_msg").empty();
$("#details_msg").empty();
if (procatename == "" || procatename == null) {
	$("#procatename").after("<span id='procatename_msg' style='color: red'>类型名称不能为空</span>");
	return false;
}
if (details == "" || details == null) {
	$("#details").after("<span id='details_msg' style='color: red'>详情不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#procatename_msg").empty();
$("#details_msg").empty();
});

});
