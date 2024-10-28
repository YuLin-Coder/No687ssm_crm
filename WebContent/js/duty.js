$(function() {

$("#dutyname").blur(
		function() {
			$("#dutyname_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#dutyname").after("<span id='dutyname_msg' style='color: red'>职位名称不能为空</span>");
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
var dutyname = $("#dutyname").val();
var details = $("#details").val();
$("#dutyname_msg").empty();
$("#details_msg").empty();
if (dutyname == "" || dutyname == null) {
	$("#dutyname").after("<span id='dutyname_msg' style='color: red'>职位名称不能为空</span>");
	return false;
}
if (details == "" || details == null) {
	$("#details").after("<span id='details_msg' style='color: red'>详情不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#dutyname_msg").empty();
$("#details_msg").empty();
});

});
