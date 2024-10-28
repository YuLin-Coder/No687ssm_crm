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
			<h1 class="page-title">编辑客户信息</h1>
		</div>
		<div class="main-content">
			<div class="row">
				<div class="col-md-6 col-md-offset-3">
					<div id="myTabContent" class="tab-content">
						<form action="customer/updateCustomer.action" name="myform" method="post" onsubmit="return check()" class="form">
							<div class="tab-pane active in" id="home">
								<div class="form-group">
									<label>姓名</label> <input type="text" name="realname" class="form-control" id="realname" value="${customer.realname}" />
								</div>
							</div>
							<div class="tab-pane active in" id="home">
								<div class="form-group">
									<label>昵称</label> <input type="text" name="nickname" class="form-control" id="nickname" value="${customer.nickname}" />
								</div>
							</div>
							<div class="tab-pane active in" id="home">
								<div class="form-group">
									<label>联系电话</label> <input type="text" name="tel" class="form-control" id="tel" value="${customer.tel}" />
								</div>
							</div>
							<div class="tab-pane active in" id="home">
								<div class="form-group">
									<label>qq号码</label> <input type="text" name="qq" class="form-control" id="qq" value="${customer.qq}" />
								</div>
							</div>
							<div class="tab-pane active in" id="home">
								<div class="form-group">
									<label>微信</label> <input type="text" name="wechat" class="form-control" id="wechat" value="${customer.wechat}" />
								</div>
							</div>
							<div class="tab-pane active in" id="home">
								<div class="form-group">
									<label>性别</label> <select class="form-control" name="sex" id="sex">
										<option value="${customer.sex }">${customer.sex }</option>
										<option value="男">男</option>
										<option value="女">女</option>
									</select>
								</div>
							</div>
							<div class="tab-pane active in" id="home">
								<div class="form-group">
									<label>出生日期</label> <input type="text" name="birthday" class="form-control" id="birthday" value="${customer.birthday}"
										onclick="WdatePicker()" readonly="readonly" />
								</div>
							</div>
							<div class="tab-pane active in" id="home">
								<div class="form-group">
									<label>客户来源</label> <select name="soureid" class="form-control" id="soureid">
										<option value="${customer.soureid}">${customer.sourename }</option>
										<c:forEach items="${soureList}" var="soure">
											<option value="${soure.soureid}">${soure.sourename }- ${soure.details }</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="tab-pane active in" id="home">
								<div class="form-group">
									<label>积分</label> <input type="text" name="integral" class="form-control" id="integral" value="${customer.integral}" />
								</div>
							</div>
							<div class="tab-pane active in" id="home">
								<div class="form-group">
									<label>客户等级</label> <select name="ranksid" class="form-control" id="ranksid">
										<option value="${customer.ranksid}">${customer.ranksname }</option>
										<c:forEach items="${ranksList}" var="ranks">
											<option value="${ranks.ranksid}">${ranks.ranksname }- ${ranks.details }</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<c:if test="${customer.ranksname == '准客户'}">
								<div class="tab-pane active in" id="home">
									<div class="form-group">
										<label>客户开发进度</label> <select name="scheduleid" class="form-control" id="scheduleid">
											<option value="${customer.scheduleid}">${customer.schedulename }</option>
											<c:forEach items="${scheduleList}" var="ranks">
												<option value="${schedule.scheduleid}">${schedule.schedulename }- ${schedule.details }</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="tab-pane active in" id="home">
									<div class="form-group">
										<label>客户开发计划</label> <input type="text" name="plan" class="form-control" id="plan" value="${customer.plan}" />
									</div>
								</div>
							</c:if>

							<div class="tab-pane active in" id="home">
								<div class="form-group">
									<label>备注</label> <input type="text" name="memo" class="form-control" id="memo" value="${customer.memo}" />
								</div>
							</div>
							<div>
								<c:if test="${customer.ranksname != '准客户'}">
									<input type="hidden" name="scheduleid" id="scheduleid" value="${customer.scheduleid}" />
									<input type="hidden" name="plan" id="plan" value="${customer.plan}" />
								</c:if>
								<input type="hidden" name="customerid" id="customerid" value="${customer.customerid}" /> <input type="hidden" name="adminid" id="adminid"
									value="${customer.adminid}" /> <input type="hidden" name="addtime" id="addtime" value="${customer.addtime}" />

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

