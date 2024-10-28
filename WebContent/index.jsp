<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
	<title>客户信息管理系统</title>
	<meta charset="utf-8">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css" type="text/css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/mycss.css" type="text/css">
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrapValidator.min.js"></script>
	<script>
		$(function () {
			//登录
			$("#submitBtn").click(function () {
				var data = $("#form").serialize();
				$.ajax({
					type: "post",
					url: "LoginServlet?method=Login",
					data: data,
					dataType: "text", //返回数据类型
					success: function (msg) {
						if ("vcodeError" == msg) {
							$('#errorinfo').text('验证码错误');
							$("#vcodeImg").click(); //切换验证码
							$("input[name='vcode']").val(""); //清空验证码输入框
						} else if ("loginError" == msg) {
							$('#errorinfo').text('用户名或密码错误');
							$("#vcodeImg").click(); //切换验证码
							$("input[name='vcode']").val(""); //清空验证码输入框
						} else if ("loginSuccess" == msg) {
							window.location.href = "SystemServlet?method=toAdminView";
						} else {
							alert(msg);
						}
					}

				});
			});

		});
	</script>

</head>

<body>
	<!-- 使用自定义css样式 div-signin 完成元素居中-->
	<div class="container div-signin">
		<div class="panel panel-primary div-shadow">
			<!-- h3标签加载自定义样式，完成文字居中和上下间距调整 -->
			<div class="panel-heading">
				<h3>客户信息管理系统</h3>
			</div>
			<div class="panel-body">
				<!-- login form start -->
				<form action="${pageContext.request.contextPath }/admin/login.action" name="myform" method="post" onSubmit="return checkLogin()" class="form-horizontal">
					<div class="form-group">
						<label class="col-sm-3 control-label">用户名：</label>
						<div class="col-sm-9">
							<input class="form-control" type="text" placeholder="请输入用户名" name="username" id="username">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">密&nbsp;&nbsp;&nbsp;&nbsp;码：</label>
						<div class="col-sm-9">
							<input class="form-control" type="password" placeholder="请输入密码" name="password" id="password">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-3">
							<span class="text-danger" id="errorinfo"></span>
						</div>
						<div class="col-sm-9 padding-left-0">
							<div class="col-sm-4">
								<button type="submit" class="btn btn-primary btn-block"
									id="submitBtn">登&nbsp;&nbsp;陆</button>
							</div>
							<div class="col-sm-4">
								<button type="reset" class="btn btn-primary btn-block">重&nbsp;&nbsp;置</button>
							</div>
							<div class="col-sm-4" style="padding:0;margin-left:-10px;width:auto;padding-top: 5px;">
							</div>
						</div>
					</div>
				</form>
				<!-- login form end -->
			</div>
		</div>
	</div>
	<!-- 页尾 版权声明 -->
	<div class="container">
		<div class="col-sm-12 foot-css">
			<p class="text-muted credit">
			</p>
		</div>
	</div>
</body>

</html>