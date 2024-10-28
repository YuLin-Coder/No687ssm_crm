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
			<h1 class="page-title">员工信息列表</h1>
		</div>
		<div class="main-content">
			<table class="table">
				<thead>
					<tr>
						<th class="text-center">用户名</th>
						<th class="text-center">姓名</th>
						<th class="text-center">性别</th>
						<th class="text-center">出生日期</th>
						<th class="text-center">联系电话</th>
						<th class="text-center">qq号码</th>
						<th class="text-center">微信</th>
						<th class="text-center">职位</th>
						<th class="text-center">入职时间</th>
						<c:if test="${sessionScope.dutyname == '超级管理员' }">
							<th class="text-center">操作</th>
						</c:if>
					</tr>
				</thead>
				<c:forEach items="${adminList}" var="admin">
					<tr align="center">
						<td>${admin.username}</td>
						<td>${admin.realname}</td>
						<td>${admin.sex}</td>
						<td>${admin.birthday}</td>
						<td>${admin.tel}</td>
						<td>${admin.qq}</td>
						<td>${admin.wechat}</td>
						<td>${admin.dutyname}</td>
						<td>${admin.addtime}</td>
						<c:if test="${sessionScope.dutyname == '超级管理员' }">
							<td><a href="admin/getAdminById.action?id=${admin.adminid}"><i class="fa fa-pencil"></i></a>&nbsp;&nbsp;<a
								href="admin/deleteAdmin.action?id=${admin.adminid}" onclick="{if(confirm('确定要删除吗?')){return true;}return false;}"><i class="fa fa-trash-o"></i></a></td>
						</c:if>
					</tr>
				</c:forEach>
			</table>
			<ul class="pagination">
				<li>
					<form action="admin/queryAdminByCond.action" name="myform" method="post">
						<label>查询条件: <select name="cond" style="width: 100px">
								<option value="username">按用户名查询</option>
								<option value="password">按密码查询</option>
								<option value="realname">按姓名查询</option>
								<option value="sex">按性别查询</option>
								<option value="birthday">按出生日期查询</option>
								<option value="tel">按联系电话查询</option>
								<option value="qq">按qq号码查询</option>
								<option value="wechat">按微信查询</option>
								<option value="dutyname">按职位查询</option>
								<option value="addtime">按入职时间查询</option>
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
