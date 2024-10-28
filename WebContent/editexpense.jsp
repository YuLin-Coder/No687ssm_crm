<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="check_logstate.jsp"></jsp:include>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
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
			<h1 class="page-title">交易信息</h1>
		</div>
		<div class="main-content">
			<div class="row">
				<div class="col-md-6 col-md-offset-3">
					<div id="myTabContent" class="tab-content">
						<form action="expense/updateExpense.action" name="myform" method="post" onsubmit="return check()" class="form">
							<div class="tab-pane active in" id="home">
								<div class="form-group">
									<label>产品</label> <select name="productid" class="form-control" id="productid">
										<option value="${expense.productid}">${expense.productname }</option>
										<c:forEach items="${productList}" var="product">
											<option value="${product.productid}">${product.productname }</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="tab-pane active in" id="home">
								<div class="form-group">
									<label>客户</label> <select name="customerid" class="form-control" id="customerid">
										<option value="${expense.customerid}">${expense.realname }</option>
										<c:forEach items="${customerList}" var="customer">
											<option value="${customer.customerid}">${customer.realname }</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="tab-pane active in" id="home">
								<div class="form-group">
									<label>价格</label> <input type="text" name="price" class="form-control" id="price" value="${expense.price }" />
								</div>
							</div>
							<div class="tab-pane active in" id="home">
								<div class="form-group">
									<label>数量</label> <input type="text" name="num" class="form-control" id="num" value="${expense.num }" />
								</div>
							</div>
							<div class="tab-pane active in" id="home">
								<div class="form-group">
									<label>付款方式</label> <select name="paywayid" class="form-control" id="paywayid">
										<option value="${expense.paywayid}">${expense.wayname }</option>
										<c:forEach items="${paywayList}" var="payway">
											<option value="${payway.paywayid}">${payway.wayname }</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="tab-pane active in" id="home">
								<div class="form-group">
									<label>备注</label> <input type="text" name="memo" class="form-control" id="memo" value="${expense.memo }" />
								</div>
							</div>

							<div>
								<input type="hidden" name="expenseid" id="expenseid" value="${expense.expenseid }" />
								<input type="hidden" name="adminid" id="adminid" value="${expense.adminid }" />
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

