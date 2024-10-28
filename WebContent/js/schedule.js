$(function() {

$("#schedulename").blur(
		function() {
			$("#schedulename_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#schedulename").after("<span id='schedulename_msg' style='color: red'>进度名称不能为空</span>");
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
var schedulename = $("#schedulename").val();
var details = $("#details").val();
$("#schedulename_msg").empty();
$("#details_msg").empty();
if (schedulename == "" || schedulename == null) {
	$("#schedulename").after("<span id='schedulename_msg' style='color: red'>进度名称不能为空</span>");
	return false;
}
if (details == "" || details == null) {
	$("#details").after("<span id='details_msg' style='color: red'>详情不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#schedulename_msg").empty();
$("#details_msg").empty();
});

});
