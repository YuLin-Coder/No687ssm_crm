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
			<h1 class="page-title">新增客户信息</h1>
		</div>
		<div class="main-content">
			<div class="row">
				<div class="col-md-6 col-md-offset-3">
					<div id="myTabContent" class="tab-content">
						<form action="customer/addCustomer.action" name="myform" method="post" onsubmit="return check()" class="form">
							<div class="tab-pane active in" id="home">
								<div class="form-group">
									<label>姓名</label> 
									<input type="text" name="realname" class="form-control" id="realname" placeholder="请输入姓名" />
								</div>
							</div>
							<div class="tab-pane active in" id="home">
								<div class="form-group">
									<label>昵称</label> 
									<input type="text" name="nickname" class="form-control" id="nickname" placeholder="请输入昵称" />
								</div>
							</div>
							<div class="tab-pane active in" id="home">
								<div class="form-group">
									<label>联系电话</label> 
									<input type="text" name="tel" class="form-control" id="tel" placeholder="请输入联系电话" />
								</div>
							</div>
							<div class="tab-pane active in" id="home">
								<div class="form-group">
									<label>qq号码</label> 
									<input type="text" name="qq" class="form-control" id="qq" placeholder="请输入qq号码" />
								</div>
							</div>
							<div class="tab-pane active in" id="home">
								<div class="form-group">
									<label>微信</label> 
									<input type="text" name="wechat" class="form-control" id="wechat" placeholder="请输入微信" />
								</div>
							</div>
							<div class="tab-pane active in" id="home">
								<div class="form-group">
									<label>性别</label> 
									<select class="form-control" name="sex" id="sex">
										<option value="男">男</option>
										<option value="女">女</option>
									</select>
								</div>
							</div>
							<div class="tab-pane active in" id="home">
								<div class="form-group">
									<label>出生日期</label> 
									<input type="text" name="birthday" class="form-control" id="birthday" onclick="WdatePicker()" readonly="readonly" placeholder="请输入出生日期" />
								</div>
							</div>
							<div class="tab-pane active in" id="home">
								<div class="form-group">
									<label>客户来源</label> 
									<select name="soureid" class="form-control" id="soureid">
										<c:forEach items="${soureList}" var="soure">
											<option value="${soure.soureid}">${soure.sourename } - ${soure.details }</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="tab-pane active in" id="home">
								<div class="form-group">
									<label>客户等级</label> 
									<select name="ranksid" class="form-control" id="ranksid" >
										<c:forEach items="${ranksList}" var="ranks">
											<option value="${ranks.ranksid}">${ranks.ranksname } - ${ranks.details }</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="tab-pane active in" id="home">
								<div class="form-group">
									<label>客户开发进度</label> 
									<select name="scheduleid" class="form-control" id="scheduleid">
										<c:forEach items="${scheduleList}" var="schedule">
											<option value="${schedule.scheduleid}">${schedule.schedulename }（${schedule.details }）</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="tab-pane active in" id="home">
								<div class="form-group">
									<label>备注</label> 
									<input type="text" name="memo" class="form-control" id="memo" value="无" />
								</div>
							</div>

							<div>
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

