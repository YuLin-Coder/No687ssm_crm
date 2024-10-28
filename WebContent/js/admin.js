$(function() {

$("#username").blur(
		function() {
			$("#username_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#username").after("<span id='username_msg' style='color: red'>用户名不能为空</span>");
			}
	});

$("#password").blur(
		function() {
			$("#password_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#password").after("<span id='password_msg' style='color: red'>密码不能为空</span>");
			}
	});

$("#realname").blur(
		function() {
			$("#realname_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#realname").after("<span id='realname_msg' style='color: red'>姓名不能为空</span>");
			}
	});

$("#birthday").blur(
		function() {
			$("#birthday_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#birthday").after("<span id='birthday_msg' style='color: red'>出生日期不能为空</span>");
			}
	});

$("#tel").blur(
		function() {
			$("#tel_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#tel").after("<span id='tel_msg' style='color: red'>联系电话不能为空</span>");
			}
	});

$("#qq").blur(
		function() {
			$("#qq_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#qq").after("<span id='qq_msg' style='color: red'>qq号码不能为空</span>");
			}
	});

$("#wechat").blur(
		function() {
			$("#wechat_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#wechat").after("<span id='wechat_msg' style='color: red'>微信不能为空</span>");
			}
	});

$("#dutyid").blur(
		function() {
			$("#dutyid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#dutyid").after("<span id='dutyid_msg' style='color: red'>职位不能为空</span>");
			}
	});







$('#sub').click(function(){
var username = $("#username").val();
var password = $("#password").val();
var realname = $("#realname").val();
var birthday = $("#birthday").val();
var tel = $("#tel").val();
var qq = $("#qq").val();
var wechat = $("#wechat").val();
var dutyid = $("#dutyid").val();
$("#username_msg").empty();
$("#password_msg").empty();
$("#realname_msg").empty();
$("#birthday_msg").empty();
$("#tel_msg").empty();
$("#qq_msg").empty();
$("#wechat_msg").empty();
$("#dutyid_msg").empty();
if (username == "" || username == null) {
	$("#username").after("<span id='username_msg' style='color: red'>用户名不能为空</span>");
	return false;
}
if (password == "" || password == null) {
	$("#password").after("<span id='password_msg' style='color: red'>密码不能为空</span>");
	return false;
}
if (realname == "" || realname == null) {
	$("#realname").after("<span id='realname_msg' style='color: red'>姓名不能为空</span>");
	return false;
}
if (birthday == "" || birthday == null) {
	$("#birthday").after("<span id='birthday_msg' style='color: red'>出生日期不能为空</span>");
	return false;
}
if (tel == "" || tel == null) {
	$("#tel").after("<span id='tel_msg' style='color: red'>联系电话不能为空</span>");
	return false;
}
if (qq == "" || qq == null) {
	$("#qq").after("<span id='qq_msg' style='color: red'>qq号码不能为空</span>");
	return false;
}
if (wechat == "" || wechat == null) {
	$("#wechat").after("<span id='wechat_msg' style='color: red'>微信不能为空</span>");
	return false;
}
if (dutyid == "" || dutyid == null) {
	$("#dutyid").after("<span id='dutyid_msg' style='color: red'>职位不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#username_msg").empty();
$("#password_msg").empty();
$("#realname_msg").empty();
$("#birthday_msg").empty();
$("#tel_msg").empty();
$("#qq_msg").empty();
$("#wechat_msg").empty();
$("#dutyid_msg").empty();
});

});
