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
			<h1 class="page-title">服务信息列表</h1>
		</div>
		<div class="main-content">
			<table class="table">
				<thead>
					<tr>
						<th class="text-center">客户</th>
						<th class="text-center">服务类型</th>
						<th class="text-center">产品</th>
						<th class="text-center">指定负责人</th>
						<th class="text-center">服务内容</th>
						<th class="text-center">服务结果总结</th>
						<th class="text-center">备注</th>
						<th class="text-center">操作</th>
					</tr>
				</thead>
				<c:forEach items="${serveList}" var="serve">
					<tr align="center">
						<td>${serve.realname}</td>
						<td>${serve.cercatename}</td>
						<td>${serve.productname}</td>
						<td>${serve.username}</td>
						<td>${serve.content}</td>
						<td>${serve.conclusion}</td>
						<td>${serve.memo}</td>
						<td><a href="serve/getServeById.action?id=${serve.serveid}"><i class="fa fa-pencil"></i></a>&nbsp;&nbsp;<a
							href="serve/deleteServe.action?id=${serve.serveid}" onclick="{if(confirm('确定要删除吗?')){return true;}return false;}"><i class="fa fa-trash-o"></i></a></td>
					</tr>
				</c:forEach>
			</table>
			<ul class="pagination">
				<li>
					<form action="serve/queryServeByCond.action" name="myform" method="post">
						<label>查询条件: <select name="cond" style="width: 100px">
								<option value="sercateid">按服务类型查询</option>
								<option value="productname">按产品查询</option>
								<option value="realname">按客户查询</option>
								<option value="username">按指定负责人查询</option>
								<option value="content">按服务内容查询</option>
								<option value="conclusion">按服务结果总结查询</option>
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
