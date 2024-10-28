$(function() {

$("#cercatename").blur(
		function() {
			$("#cercatename_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#cercatename").after("<span id='cercatename_msg' style='color: red'>类型名称不能为空</span>");
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
var cercatename = $("#cercatename").val();
var details = $("#details").val();
$("#cercatename_msg").empty();
$("#details_msg").empty();
if (cercatename == "" || cercatename == null) {
	$("#cercatename").after("<span id='cercatename_msg' style='color: red'>类型名称不能为空</span>");
	return false;
}
if (details == "" || details == null) {
	$("#details").after("<span id='details_msg' style='color: red'>详情不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#cercatename_msg").empty();
$("#details_msg").empty();
});

});
