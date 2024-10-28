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
			<ul class="pagination">
				<li>
					<form action="product/queryProductByCond.action" name="myform" method="post">
						<label>查询条件: <select name="cond" style="width: 100px">
								<option value="procateid">按产品类型查询</option>
								<option value="productname">按产品名称查询</option>
								<option value="details">按产品介绍查询</option>
								<option value="price">按产品价格查询</option>
								<option value="inventory">按库存量查询</option>
								<option value="num">按已售数量查询</option>
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
