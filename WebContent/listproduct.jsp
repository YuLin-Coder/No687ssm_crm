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
			<h1 class="page-title">产品信息列表</h1>
		</div>
		<div class="main-content">
			<table class="table">

				<thead>
					<tr>
						<th class="text-center">产品名称</th>
						<th class="text-center">产品类型</th>
						<th class="text-center">产品介绍</th>
						<th class="text-center">产品价格</th>
						<th class="text-center">库存量</th>
						<th class="text-center">已售数量</th>
						<th class="text-center">备注</th>
						<c:if test="${sessionScope.dutyname == '超级管理员' }">
							<th class="text-center">操作</th>
						</c:if>
					</tr>
				</thead>
				<c:forEach items="${productList}" var="product">
					<tr align="center">
						<td>${product.productname}</td>
						<td>${product.procatename}</td>
						<td>${product.details}</td>
						<td>${product.price}</td>
						<td>${product.inventory}</td>
						<td>${product.num}</td>
						<td>${product.memo}</td>
						<c:if test="${sessionScope.dutyname == '超级管理员' }">
							<td><a href="product/getProductById.action?id=${product.productid}"><i class="fa fa-pencil"></i></a>&nbsp;&nbsp;<a
								href="product/deleteProduct.action?id=${product.productid}" onclick="{if(confirm('确定要删除吗?')){return true;}return false;}"><i
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
