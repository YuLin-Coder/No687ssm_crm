<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="check_logstate.jsp"></jsp:include>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%><!doctype html>
<html lang="zh_CN">
<head>
<base href="<%=basePath%>" />
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
			<ul class="pagination">
				<li>
					<form action="customer/queryCustomerByCond.action" name="myform" method="post">
						<label>查询条件: <select name="cond" style="width: 100px">
								<option value="realname">按姓名查询</option>
								<option value="nickname">按昵称查询</option>
								<option value="tel">按联系电话查询</option>
								<option value="qq">按qq号码查询</option>
								<option value="wechat">按微信查询</option>
								<option value="sex">按性别查询</option>
								<option value="birthday">按出生日期查询</option>
								<option value="sourename">按客户来源查询</option>
								<option value="addtime">按录入时间查询</option>
								<option value="username">按录入人员查询</option>
								<option value="integral">按积分查询</option>
								<option value="ranksname">按客户等级查询</option>
								<option value="schedulename">按客户开发进度查询</option>
								<option value="plan">按客户开发计划查询</option>
								<option value="memo">按备注查询</option>
						</select>
						</label>&nbsp;&nbsp;&nbsp; <label>关键字: <input type="text" name="name" required style="width: 100px" /></label>&nbsp;&nbsp;&nbsp; <label><input
							type="submit" value="查询" class="mws-button green" /> </label>${html }
					</form>
				</li>
			</ul>
		</div>
	</div>
</body>
</html>
