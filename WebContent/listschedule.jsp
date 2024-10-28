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
			<h1 class="page-title">客户开发进度信息列表</h1>
		</div>
		<div class="main-content">
			<table class="table">

				<thead>
					<tr>
						<th class="text-center">进度名称</th>
						<th class="text-center">详情</th>
						<c:if test="${sessionScope.dutyname == '超级管理员' }">
							<th class="text-center">操作</th>
						</c:if>
					</tr>
				</thead>
				<c:forEach items="${scheduleList}" var="schedule">
					<tr align="center">
						<td>${schedule.schedulename}</td>
						<td>${schedule.details}</td>
						<c:if test="${sessionScope.dutyname == '超级管理员' }">
							<td><a href="schedule/getScheduleById.action?id=${schedule.scheduleid}"><i class="fa fa-pencil"></i></a>&nbsp;&nbsp;<a
								href="schedule/deleteSchedule.action?id=${schedule.scheduleid}" onclick="{if(confirm('确定要删除吗?')){return true;}return false;}"><i
									class="fa fa-trash-o"></i></a></td>
						</c:if>
					</tr>
				</c:forEach>
			</table>
			<div class="pagination">${html }</div>
		</div>
	</div>
</body>
</html>
