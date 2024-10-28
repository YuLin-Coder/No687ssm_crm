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
<script type="text/javascript" src="js/selimage.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=basePath%>My97DatePicker/WdatePicker.js" charset="utf-8"></script>
</head>
<body class=" theme-blue">
	<jsp:include page="top.jsp"></jsp:include>
	<jsp:include page="menu.jsp"></jsp:include>
	<div class="content">
		<div class="header">
			<h1 class="page-title">编辑服务信息</h1>
		</div>
		<div class="main-content">
			<div class="row">
				<div class="col-md-6 col-md-offset-3">
					<div id="myTabContent" class="tab-content">
						<form action="serve/updateServe.action" name="myform" method="post" onsubmit="return check()" class="form">

							<div class="tab-pane active in" id="home">
								<div class="form-group">
									<label>服务类型</label>
									<c:if test="${sessionScope.dutyname == '超级管理员' || sessionScope.dutyname == '营销主管'}">
										<select name="sercateid" class="form-control" id="sercateid">
											<option value="${serve.sercateid}">${serve.cercatename }</option>
											<c:forEach items="${sercateList}" var="sercate">
												<option value="${sercate.sercateid}">${sercate.cercatename }</option>
											</c:forEach>
										</select>
									</c:if>
									<c:if test="${sessionScope.dutyname == '客户经理'}">
										：${serve.cercatename }
										<input type="hidden" name="sercateid" id="sercateid" value="${serve.sercateid }" />
									</c:if>
								</div>
							</div>
							<div class="tab-pane active in" id="home">
								<div class="form-group">
									<label>产品</label>
									<c:if test="${sessionScope.dutyname == '超级管理员' || sessionScope.dutyname == '营销主管'}">
										<select name="productid" class="form-control" id="productid">
											<option value="${serve.productid}">${serve.productname }</option>
											<c:forEach items="${productList}" var="product">
												<option value="${product.productid}">${product.productname }</option>
											</c:forEach>
										</select>
									</c:if>
									<c:if test="${sessionScope.dutyname == '客户经理'}">
										：${serve.productname }
										<input type="hidden" name="productid" id="productid" value="${serve.productid }" />
									</c:if>
								</div>
							</div>
							<div class="tab-pane active in" id="home">
								<div class="form-group">
									<label>客户</label>
									<c:if test="${sessionScope.dutyname == '超级管理员' || sessionScope.dutyname == '营销主管'}">
										<select name="customerid" class="form-control" id="customerid">
											<option value="${serve.customerid}">${serve.realname }</option>
											<c:forEach items="${customerList}" var="customer">
												<option value="${customer.customerid}">${customer.realname }</option>
											</c:forEach>
										</select>
									</c:if>
									<c:if test="${sessionScope.dutyname == '客户经理'}">
										：${serve.realname }
										<input type="hidden" name="customerid" id="customerid" value="${serve.customerid }" />
									</c:if>
								</div>
							</div>
							<div class="tab-pane active in" id="home">
								<div class="form-group">
									<label>指定负责人</label>
									<c:if test="${sessionScope.dutyname == '超级管理员' || sessionScope.dutyname == '营销主管'}">
										<select name="adminid" class="form-control" id="adminid">
											<option value="${serve.adminid}">${serve.username }</option>
											<c:forEach items="${adminList}" var="admin">
												<c:if test="${admin.dutyname == '客户经理' }">
													<option value="${admin.adminid}">${admin.username }</option>
												</c:if>
											</c:forEach>
										</select>
									</c:if>
									<c:if test="${sessionScope.dutyname == '客户经理'}">
										：${serve.username }
										<input type="hidden" name="adminid" id="adminid" value="${serve.adminid }" />
									</c:if>
								</div>
							</div>
							<div class="tab-pane active in" id="home">
								<div class="form-group">
									<label>服务内容</label> <input type="text" name="content" class="form-control" id="content" value="${serve.content}" />
								</div>
							</div>
							<div class="tab-pane active in" id="home">
								<div class="form-group">
									<label>服务结果总结</label> <select name="conclusion" class="form-control" id="conclusion">
										<option value="${serve.conclusion}">${serve.conclusion}</option>
										<option value="处理中">处理中</option>
										<option value="完成">完成</option>
										<option value="待处理">待处理</option>
									</select>
								</div>
							</div>
							<div class="tab-pane active in" id="home">
								<div class="form-group">
									<label>备注</label> <input type="text" name="memo" class="form-control" id="memo" value="${serve.memo}" />
								</div>
							</div>
							<div>
								<input type="hidden" name="serveid" id="serveid" value="${serve.serveid}" />
								<button type="submit" id="sub" class="btn btn-primary">提交保存</button>
								&nbsp;&nbsp;&nbsp;
								<button type="reset" id="res" class="btn btn-primary">取消重置</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

