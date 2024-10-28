$(function() {

$("#sercateid").blur(
		function() {
			$("#sercateid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#sercateid").after("<span id='sercateid_msg' style='color: red'>服务类型不能为空</span>");
			}
	});

$("#productid").blur(
		function() {
			$("#productid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#productid").after("<span id='productid_msg' style='color: red'>产品不能为空</span>");
			}
	});

$("#customerid").blur(
		function() {
			$("#customerid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#customerid").after("<span id='customerid_msg' style='color: red'>客户不能为空</span>");
			}
	});

$("#adminid").blur(
		function() {
			$("#adminid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#adminid").after("<span id='adminid_msg' style='color: red'>指定负责人不能为空</span>");
			}
	});

$("#content").blur(
		function() {
			$("#content_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#content").after("<span id='content_msg' style='color: red'>服务内容不能为空</span>");
			}
	});

$("#conclusion").blur(
		function() {
			$("#conclusion_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#conclusion").after("<span id='conclusion_msg' style='color: red'>服务结果总结不能为空</span>");
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
var sercateid = $("#sercateid").val();
var productid = $("#productid").val();
var customerid = $("#customerid").val();
var adminid = $("#adminid").val();
var content = $("#content").val();
var conclusion = $("#conclusion").val();
var memo = $("#memo").val();
$("#sercateid_msg").empty();
$("#productid_msg").empty();
$("#customerid_msg").empty();
$("#adminid_msg").empty();
$("#content_msg").empty();
$("#conclusion_msg").empty();
$("#memo_msg").empty();
if (sercateid == "" || sercateid == null) {
	$("#sercateid").after("<span id='sercateid_msg' style='color: red'>服务类型不能为空</span>");
	return false;
}
if (productid == "" || productid == null) {
	$("#productid").after("<span id='productid_msg' style='color: red'>产品不能为空</span>");
	return false;
}
if (customerid == "" || customerid == null) {
	$("#customerid").after("<span id='customerid_msg' style='color: red'>客户不能为空</span>");
	return false;
}
if (adminid == "" || adminid == null) {
	$("#adminid").after("<span id='adminid_msg' style='color: red'>指定负责人不能为空</span>");
	return false;
}
if (content == "" || content == null) {
	$("#content").after("<span id='content_msg' style='color: red'>服务内容不能为空</span>");
	return false;
}
if (conclusion == "" || conclusion == null) {
	$("#conclusion").after("<span id='conclusion_msg' style='color: red'>服务结果总结不能为空</span>");
	return false;
}
if (memo == "" || memo == null) {
	$("#memo").after("<span id='memo_msg' style='color: red'>备注不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#sercateid_msg").empty();
$("#productid_msg").empty();
$("#customerid_msg").empty();
$("#adminid_msg").empty();
$("#content_msg").empty();
$("#conclusion_msg").empty();
$("#memo_msg").empty();
});

});
