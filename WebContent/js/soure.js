$(function() {

$("#sourename").blur(
		function() {
			$("#sourename_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#sourename").after("<span id='sourename_msg' style='color: red'>来源不能为空</span>");
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
var sourename = $("#sourename").val();
var details = $("#details").val();
$("#sourename_msg").empty();
$("#details_msg").empty();
if (sourename == "" || sourename == null) {
	$("#sourename").after("<span id='sourename_msg' style='color: red'>来源不能为空</span>");
	return false;
}
if (details == "" || details == null) {
	$("#details").after("<span id='details_msg' style='color: red'>详情不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#sourename_msg").empty();
$("#details_msg").empty();
});

});
