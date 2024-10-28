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
<script type="text/javascript" src="js/admin.js" charset="utf-8"></script>
<script type="text/javascript" src="js/selimage.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=basePath%>My97DatePicker/WdatePicker.js" charset="utf-8"></script>
</head>
<body class=" theme-blue">
	<jsp:include page="top.jsp"></jsp:include>
	<jsp:include page="menu.jsp"></jsp:include>
	<div class="content">
		<div class="header">
			<h1 class="page-title">编辑员工信息</h1>
		</div>
		<div class="main-content">
			<div class="row">
				<div class="col-md-6 col-md-offset-3">
					<div id="myTabContent" class="tab-content">
						<form action="admin/updateAdmin.action" name="myform" method="post" onsubmit="return check()" class="form">

							<div class="tab-pane active in" id="home">
								<div class="form-group">
									<label>用户名</label> <input type="text" name="username" class="form-control" id="username" value="${admin.username}" />
								</div>
							</div>
							<div class="tab-pane active in" id="home">
								<div class="form-group">
									<label>姓名</label> <input type="text" name="realname" class="form-control" id="realname" value="${admin.realname}" />
								</div>
							</div>
							<div class="tab-pane active in" id="home">
								<div class="form-group">
									<label>性别</label> <select class="form-control" name="sex" id="sex">
										<option value="${admin.sex }">${admin.sex }</option>
										<option value="男">男</option>
										<option value="女">女</option>
									</select>
								</div>
							</div>
							<div class="tab-pane active in" id="home">
								<div class="form-group">
									<label>出生日期</label> <input type="text" name="birthday" class="form-control" id="birthday" value="${admin.birthday}" onclick="WdatePicker()"
										readonly="readonly" />
								</div>
							</div>
							<div class="tab-pane active in" id="home">
								<div class="form-group">
									<label>联系电话</label> <input type="text" name="tel" class="form-control" id="tel" value="${admin.tel}" />
								</div>
							</div>
							<div class="tab-pane active in" id="home">
								<div class="form-group">
									<label>qq号码</label> <input type="text" name="qq" class="form-control" id="qq" value="${admin.qq}" />
								</div>
							</div>
							<div class="tab-pane active in" id="home">
								<div class="form-group">
									<label>微信</label> <input type="text" name="wechat" class="form-control" id="wechat" value="${admin.wechat}" />
								</div>
							</div>
							<div class="tab-pane active in" id="home">
								<div class="form-group">
									<label>职位</label> <select name="dutyid" class="form-control" id="dutyid">
										<option value="${admin.dutyid}">${admin.dutyname }</option>
										<c:forEach items="${dutyList}" var="duty">
											<option value="${duty.dutyid}">${duty.dutyname }</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div>
								<input type="hidden" name="adminid" id="adminid" value="${admin.adminid}" /><input type="hidden" name="password" id="password"
									value="${admin.password}" /> <input type="hidden" name="addtime" id="addtime" value="${admin.addtime}" />

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

