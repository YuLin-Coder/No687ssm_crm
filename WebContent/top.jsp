<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="check_logstate.jsp"/>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<style type="text/css">
.navbar-default .navbar-brand, .navbar-default .navbar-brand:hover {
	color: #fff;
}
</style>
<div class="navbar navbar-default" role="navigation">
	<div class="navbar-header">
		<a class=""><span class="navbar-brand"><span class="fa fa-paper-plane"></span> 客户信息管理系统</span></a>
	</div>
	<div class="navbar-collapse collapse" style="height: 1px;">
		<ul id="main-menu" class="nav navbar-nav navbar-right">
		<c:if test="${sessionScope.dutyname == '客户经理' }">
			<li class="dropdown hidden-xs"><a href="serve/getMyReServe.action" title=""><span>服务处理</span></a></li>
	</c:if>
			<li class="dropdown hidden-xs"><a class="dropdown-toggle" data-toggle="dropdown"> <span
					class="glyphicon glyphicon-user padding-right-small" style="position: relative; top: 3px;"></span>
					${sessionScope.realname }
			</a></li>
			<li class="dropdown hidden-xs"><a class="dropdown-toggle" data-toggle="dropdown"> <span id="time"></span> <script>
				document.getElementById('time').innerHTML = new Date()
						.toLocaleString()
						+ ' 星期' + '日一二三四五六'.charAt(new Date().getDay());
				setInterval(
						"document.getElementById('time').innerHTML=new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay());",
						1000);
			</script></a></li>
			<li class="dropdown hidden-xs"><a href="editpwd.jsp" title=""><span>修改密码</span></a></li>
			<li class="dropdown hidden-xs"><a href="<%=basePath%>admin/exit.action"
				onclick="{if(confirm('确定要退出吗?')){return true;}return false;}" title=""><span>退出系统</span></a></li>
		</ul>
	</div>
</div>