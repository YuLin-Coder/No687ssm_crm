$(function() {

$("#wayname").blur(
		function() {
			$("#wayname_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#wayname").after("<span id='wayname_msg' style='color: red'>方式不能为空</span>");
			}
	});

$("#payee").blur(
		function() {
			$("#payee_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#payee").after("<span id='payee_msg' style='color: red'>收款账户不能为空</span>");
			}
	});

$("#memo").blur(
		function() {
			$("#memo_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#memo").after("<span id='memo_msg' style='color: red'>备注不能为空</span>");
			}
	});







$('#sub').click(function(){
var wayname = $("#wayname").val();
var payee = $("#payee").val();
var memo = $("#memo").val();
$("#wayname_msg").empty();
$("#payee_msg").empty();
$("#memo_msg").empty();
if (wayname == "" || wayname == null) {
	$("#wayname").after("<span id='wayname_msg' style='color: red'>方式不能为空</span>");
	return false;
}
if (payee == "" || payee == null) {
	$("#payee").after("<span id='payee_msg' style='color: red'>收款账户不能为空</span>");
	return false;
}
if (memo == "" || memo == null) {
	$("#memo").after("<span id='memo_msg' style='color: red'>备注不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#wayname_msg").empty();
$("#payee_msg").empty();
$("#memo_msg").empty();
});

});
