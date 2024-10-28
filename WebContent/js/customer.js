$(function() {

$("#realname").blur(
		function() {
			$("#realname_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#realname").after("<span id='realname_msg' style='color: red'>姓名不能为空</span>");
			}
	});

$("#nickname").blur(
		function() {
			$("#nickname_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#nickname").after("<span id='nickname_msg' style='color: red'>昵称不能为空</span>");
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

$("#birthday").blur(
		function() {
			$("#birthday_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#birthday").after("<span id='birthday_msg' style='color: red'>出生日期不能为空</span>");
			}
	});

$("#custypeid").blur(
		function() {
			$("#custypeid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#custypeid").after("<span id='custypeid_msg' style='color: red'>客户类型不能为空</span>");
			}
	});

$("#soureid").blur(
		function() {
			$("#soureid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#soureid").after("<span id='soureid_msg' style='color: red'>客户来源不能为空</span>");
			}
	});

$("#adminid").blur(
		function() {
			$("#adminid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#adminid").after("<span id='adminid_msg' style='color: red'>录入人员不能为空</span>");
			}
	});

$("#expenseid").blur(
		function() {
			$("#expenseid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#expenseid").after("<span id='expenseid_msg' style='color: red'>消费记录不能为空</span>");
			}
	});

$("#integral").blur(
		function() {
			$("#integral_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#integral").after("<span id='integral_msg' style='color: red'>积分不能为空</span>");
			}
	});

$("#ranksid").blur(
		function() {
			$("#ranksid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#ranksid").after("<span id='ranksid_msg' style='color: red'>客户等级不能为空</span>");
			}
	});

$("#scheduleid").blur(
		function() {
			$("#scheduleid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#scheduleid").after("<span id='scheduleid_msg' style='color: red'>客户开发进度不能为空</span>");
			}
	});

$("#plan").blur(
		function() {
			$("#plan_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#plan").after("<span id='plan_msg' style='color: red'>客户开发计划不能为空</span>");
			}
	});

$("#serveid").blur(
		function() {
			$("#serveid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#serveid").after("<span id='serveid_msg' style='color: red'>服务记录不能为空</span>");
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
var realname = $("#realname").val();
var nickname = $("#nickname").val();
var tel = $("#tel").val();
var qq = $("#qq").val();
var wechat = $("#wechat").val();
var birthday = $("#birthday").val();
var custypeid = $("#custypeid").val();
var soureid = $("#soureid").val();
var adminid = $("#adminid").val();
var expenseid = $("#expenseid").val();
var integral = $("#integral").val();
var ranksid = $("#ranksid").val();
var scheduleid = $("#scheduleid").val();
var plan = $("#plan").val();
var serveid = $("#serveid").val();
var memo = $("#memo").val();
$("#realname_msg").empty();
$("#nickname_msg").empty();
$("#tel_msg").empty();
$("#qq_msg").empty();
$("#wechat_msg").empty();
$("#birthday_msg").empty();
$("#custypeid_msg").empty();
$("#soureid_msg").empty();
$("#adminid_msg").empty();
$("#expenseid_msg").empty();
$("#integral_msg").empty();
$("#ranksid_msg").empty();
$("#scheduleid_msg").empty();
$("#plan_msg").empty();
$("#serveid_msg").empty();
$("#memo_msg").empty();
if (realname == "" || realname == null) {
	$("#realname").after("<span id='realname_msg' style='color: red'>姓名不能为空</span>");
	return false;
}
if (nickname == "" || nickname == null) {
	$("#nickname").after("<span id='nickname_msg' style='color: red'>昵称不能为空</span>");
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
if (birthday == "" || birthday == null) {
	$("#birthday").after("<span id='birthday_msg' style='color: red'>出生日期不能为空</span>");
	return false;
}
if (custypeid == "" || custypeid == null) {
	$("#custypeid").after("<span id='custypeid_msg' style='color: red'>客户类型不能为空</span>");
	return false;
}
if (soureid == "" || soureid == null) {
	$("#soureid").after("<span id='soureid_msg' style='color: red'>客户来源不能为空</span>");
	return false;
}
if (adminid == "" || adminid == null) {
	$("#adminid").after("<span id='adminid_msg' style='color: red'>录入人员不能为空</span>");
	return false;
}
if (expenseid == "" || expenseid == null) {
	$("#expenseid").after("<span id='expenseid_msg' style='color: red'>消费记录不能为空</span>");
	return false;
}
if (integral == "" || integral == null) {
	$("#integral").after("<span id='integral_msg' style='color: red'>积分不能为空</span>");
	return false;
}
if (ranksid == "" || ranksid == null) {
	$("#ranksid").after("<span id='ranksid_msg' style='color: red'>客户等级不能为空</span>");
	return false;
}
if (scheduleid == "" || scheduleid == null) {
	$("#scheduleid").after("<span id='scheduleid_msg' style='color: red'>客户开发进度不能为空</span>");
	return false;
}
if (plan == "" || plan == null) {
	$("#plan").after("<span id='plan_msg' style='color: red'>客户开发计划不能为空</span>");
	return false;
}
if (serveid == "" || serveid == null) {
	$("#serveid").after("<span id='serveid_msg' style='color: red'>服务记录不能为空</span>");
	return false;
}
if (memo == "" || memo == null) {
	$("#memo").after("<span id='memo_msg' style='color: red'>备注不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#realname_msg").empty();
$("#nickname_msg").empty();
$("#tel_msg").empty();
$("#qq_msg").empty();
$("#wechat_msg").empty();
$("#birthday_msg").empty();
$("#custypeid_msg").empty();
$("#soureid_msg").empty();
$("#adminid_msg").empty();
$("#expenseid_msg").empty();
$("#integral_msg").empty();
$("#ranksid_msg").empty();
$("#scheduleid_msg").empty();
$("#plan_msg").empty();
$("#serveid_msg").empty();
$("#memo_msg").empty();
});

});
