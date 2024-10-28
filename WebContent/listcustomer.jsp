<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="check_logstate.jsp"></jsp:include>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!doctype html>
<html lang="zh_CN">
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户管理系统</title>
<link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">
<script src="lib/jquery-1.11.1.min.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
<link rel="stylesheet" type="text/css" href="stylesheets/premium.css">
</head>
<body class=" theme-blue">
	<jsp:include page="top.jsp"></jsp:include>
	<jsp:include page="menu.jsp"></jsp:include>
	<div class="content">
		<div class="header">
			<h1 class="page-title">客户信息列表</h1>
		</div>
		<div class="main-content">
			<table class="table">

				<thead>
					<tr>
						<th class="text-center">姓名</th>
						<th class="text-center">昵称</th>
						<th class="text-center">联系电话</th>
						<th class="text-center">qq号码</th>
						<th class="text-center">微信</th>
						<th class="text-center">性别</th>
						<th class="text-center">出生日期</th>
						<th class="text-center">客户来源</th>
						<th class="text-center">录入时间</th>
						<th class="text-center">录入人员</th>
						<th class="text-center">积分</th>
						<th class="text-center">客户等级</th>
						<th class="text-center">客户开发进度</th>
						<th class="text-center">客户开发计划</th>
						<th class="text-center">备注</th>
						<th class="text-center">操作</th>
					</tr>
				</thead>
				<c:forEach items="${customerList}" var="customer">
					<tr align="center">
						<td>${customer.realname}</td>
						<td>${customer.nickname}</td>
						<td>${customer.tel}</td>
						<td>${customer.qq}</td>
						<td>${customer.wechat}</td>
						<td>${customer.sex}</td>
						<td>${customer.birthday}</td>
						<td>${customer.sourename}</td>
						<td>${customer.addtime}</td>
						<td>${customer.username}</td>
						<td>${customer.integral}</td>
						<td>${customer.ranksname}</td>
						<td>${customer.schedulename}</td>
						<td>${customer.plan}</td>
						<td>${customer.memo}</td>
						<td><a href="customer/getCustomerById.action?id=${customer.customerid}"><i class="fa fa-pencil"></i></a>&nbsp;&nbsp;<a
							href="customer/deleteCustomer.action?id=${customer.customerid}" onclick="{if(confirm('确定要删除吗?')){return true;}return false;}"><i
								class="fa fa-trash-o"></i></a></td>
					</tr>
				</c:forEach>
			</table>
			<div class="pagination">${html }</div>
		</div>
	</div>
</body>
</html>
