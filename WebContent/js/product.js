$(function() {

$("#procateid").blur(
		function() {
			$("#procateid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#procateid").after("<span id='procateid_msg' style='color: red'>产品类型不能为空</span>");
			}
	});

$("#productname").blur(
		function() {
			$("#productname_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#productname").after("<span id='productname_msg' style='color: red'>产品名称不能为空</span>");
			}
	});

$("#details").blur(
		function() {
			$("#details_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#details").after("<span id='details_msg' style='color: red'>产品介绍不能为空</span>");
			}
	});

$("#price").blur(
		function() {
			$("#price_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#price").after("<span id='price_msg' style='color: red'>产品价格不能为空</span>");
			}
	});

$("#inventory").blur(
		function() {
			$("#inventory_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#inventory").after("<span id='inventory_msg' style='color: red'>库存量不能为空</span>");
			}
	});

$("#num").blur(
		function() {
			$("#num_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#num").after("<span id='num_msg' style='color: red'>已售数量不能为空</span>");
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
var procateid = $("#procateid").val();
var productname = $("#productname").val();
var details = $("#details").val();
var price = $("#price").val();
var inventory = $("#inventory").val();
var num = $("#num").val();
var memo = $("#memo").val();
$("#procateid_msg").empty();
$("#productname_msg").empty();
$("#details_msg").empty();
$("#price_msg").empty();
$("#inventory_msg").empty();
$("#num_msg").empty();
$("#memo_msg").empty();
if (procateid == "" || procateid == null) {
	$("#procateid").after("<span id='procateid_msg' style='color: red'>产品类型不能为空</span>");
	return false;
}
if (productname == "" || productname == null) {
	$("#productname").after("<span id='productname_msg' style='color: red'>产品名称不能为空</span>");
	return false;
}
if (details == "" || details == null) {
	$("#details").after("<span id='details_msg' style='color: red'>产品介绍不能为空</span>");
	return false;
}
if (price == "" || price == null) {
	$("#price").after("<span id='price_msg' style='color: red'>产品价格不能为空</span>");
	return false;
}
if (inventory == "" || inventory == null) {
	$("#inventory").after("<span id='inventory_msg' style='color: red'>库存量不能为空</span>");
	return false;
}
if (num == "" || num == null) {
	$("#num").after("<span id='num_msg' style='color: red'>已售数量不能为空</span>");
	return false;
}
if (memo == "" || memo == null) {
	$("#memo").after("<span id='memo_msg' style='color: red'>备注不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#procateid_msg").empty();
$("#productname_msg").empty();
$("#details_msg").empty();
$("#price_msg").empty();
$("#inventory_msg").empty();
$("#num_msg").empty();
$("#memo_msg").empty();
});

});
