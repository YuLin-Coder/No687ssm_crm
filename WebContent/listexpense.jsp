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
			<h1 class="page-title">交易记录列表</h1>
		</div>
		<div class="main-content">
			<table class="table">

				<thead>
					<tr>
						<th class="text-center">产品</th>
						<th class="text-center">客户</th>
						<th class="text-center">价格</th>
						<th class="text-center">数量</th>
						<th class="text-center">支付方式</th>
						<th class="text-center">业务员</th>
						<th class="text-center">备注</th>
						<th class="text-center">操作</th>
					</tr>
				</thead>
				<c:forEach items="${expenseList}" var="expense">
					<tr align="center">
						<td>${expense.productname}</td>
						<td>${expense.realname}</td>
						<td>${expense.price}</td>
						<td>${expense.num}</td>
						<td>${expense.wayname}</td>
						<td>${expense.username}</td>
						<td>${expense.memo}</td>
						<td><a href="expense/getExpenseById.action?id=${expense.expenseid}"><i class="fa fa-pencil"></i></a>&nbsp;&nbsp;<a
							href="expense/deleteExpense.action?id=${expense.expenseid}" onclick="{if(confirm('确定要删除吗?')){return true;}return false;}"><i class="fa fa-trash-o"></i></a></td>
					</tr>
				</c:forEach>
			</table>
			<div class="pagination">${html }</div>
		</div>
	</div>
</body>
</html>
