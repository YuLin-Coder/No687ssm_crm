<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript">
	$(function() {
		var uls = $('.sidebar-nav > ul > *').clone();
		uls.addClass('visible-xs');
		$('#main-menu').append(uls.clone());
	});
</script>
<script src="lib/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript">
	$("[rel=tooltip]").tooltip();
	$(function() {
		$('.demo-cancel-click').click(function() {
			return false;
		});
		
		/*
		 * 实现当前菜单项的高亮
		 */ 
		$('.nav-list li a').click(function(){
			let href = $(this).attr('href')
			localStorage.setItem('crm_href',href)
		})
		
		let href = localStorage.getItem('crm_href')
		let a = $('a[href="'+href+'"]')
		a.css('color','#ff7300')
		
		$('.nav-list').removeClass('in')		
		a.parent().parent().addClass('in')
		
	});
</script>
<div class="sidebar-nav">
	<ul>

		<li><span class="nav-header collapsed" data-toggle="collapse"><strong>系统管理菜单</strong></span></li>
		<c:if test="${sessionScope.dutyname != '客户经理'}">
			<li><a data-target=".legal-menu7" class="nav-header collapsed" data-toggle="collapse">员工信息管理<i class="fa fa-collapse"></i></a></li>
			<li>
				<ul class="legal-menu7 nav nav-list collapse">
					<c:if test="${sessionScope.dutyname == '超级管理员' }">
						<li><a href="admin/createAdmin.action"><span class="fa fa-caret-right"></span>新增员工信息</a></li>
					</c:if>
					<li><a href="admin/getAllAdmin.action"><span class="fa fa-caret-right"></span>员工信息列表</a></li>
					<li><a href="admin/queryAdminByCond.action"><span class="fa fa-caret-right"></span>员工信息查询</a></li>
				</ul>
			</li>
		</c:if>
		<li><a data-target=".legal-menu9" class="nav-header collapsed" data-toggle="collapse">产品信息管理<i
				class="fa fa-collapse"></i></a></li>
		<li>
			<ul class="legal-menu9 nav nav-list collapse">
				<c:if test="${sessionScope.dutyname == '超级管理员' }">
					<li><a href="product/createProduct.action"><span class="fa fa-caret-right"></span>新增产品信息</a></li>
				</c:if>
				<li><a href="product/getAllProduct.action"><span class="fa fa-caret-right"></span>产品信息列表</a></li>
				<li><a href="product/queryProductByCond.action"><span class="fa fa-caret-right"></span>产品信息查询</a></li>
			</ul>
		</li>

		<li><a data-target=".legal-menu8" class="nav-header collapsed" data-toggle="collapse">客户信息管理<i
				class="fa fa-collapse"></i></a></li>
		<li>
			<ul class="legal-menu8 nav nav-list collapse in">
				<li><a href="customer/createCustomer.action"><span class="fa fa-caret-right"></span>新增客户信息</a></li>
				<li><a href="customer/getAllCustomer.action"><span class="fa fa-caret-right"></span>客户信息列表</a></li>
				<li><a href="customer/queryCustomerByCond.action"><span class="fa fa-caret-right"></span>客户信息查询</a></li>
				<li><a href="customer.jsp"><span class="fa fa-caret-right"></span>客户信息分析</a></li>
			</ul>
		</li>

		<li><a data-target=".legal-menu10" class="nav-header collapsed" data-toggle="collapse">服务信息管理<i
				class="fa fa-collapse"></i></a></li>
		<li>
			<ul class="legal-menu10 nav nav-list collapse in">
				<c:if test="${sessionScope.dutyname == '超级管理员' || sessionScope.dutyname == '营销主管'}">
					<li><a href="serve/createServe.action"><span class="fa fa-caret-right"></span>新增服务信息</a></li>
					<li><a href="serve/getAllServe.action"><span class="fa fa-caret-right"></span>服务信息列表</a></li>
					<li><a href="serve/queryServeByCond.action"><span class="fa fa-caret-right"></span>服务信息查询</a></li>
				</c:if>
				<li><a href="serve/getMyReServe.action"><span class="fa fa-caret-right"></span>服务处理</a></li>
				<li><a href="serve/getMyServe.action"><span class="fa fa-caret-right"></span>自己相关服务</a></li>
			</ul>
		</li>

		<li><a data-target=".legal-menu11" class="nav-header collapsed" data-toggle="collapse">交易信息管理<i
				class="fa fa-collapse"></i></a></li>
		<li>
			<ul class="legal-menu11 nav nav-list collapse">
				<li><a href="expense/createExpense.action"><span class="fa fa-caret-right"></span>新增交易信息</a></li>
				<li><a href="expense/getAllExpense.action"><span class="fa fa-caret-right"></span>交易信息列表</a></li>
				<li><a href="expense/queryExpenseByCond.action"><span class="fa fa-caret-right"></span>交易信息查询</a></li>
				<li><a href="expense.jsp"><span class="fa fa-caret-right"></span>交易记录分析</a></li>
			</ul>
		</li>


		<c:if test="${sessionScope.dutyname == '超级管理员' }">
			<li><a data-target=".legal-menu2" class="nav-header collapsed" data-toggle="collapse">客户来源信息管理<i
					class="fa fa-collapse"></i></a></li>
			<li>
				<ul class="legal-menu2 nav nav-list collapse">
					<li><a href="soure/createSoure.action"><span class="fa fa-caret-right"></span>新增客户来源信息</a></li>
					<li><a href="soure/getAllSoure.action"><span class="fa fa-caret-right"></span>客户来源信息列表</a></li>
					<li><a href="soure/querySoureByCond.action"><span class="fa fa-caret-right"></span>客户来源信息查询</a></li>
				</ul>
			</li>

			<li><a data-target=".legal-menu3" class="nav-header collapsed" data-toggle="collapse">支付方式信息管理<i
					class="fa fa-collapse"></i></a></li>
			<li>
				<ul class="legal-menu3 nav nav-list collapse">
					<li><a href="payway/createPayway.action"><span class="fa fa-caret-right"></span>新增支付方式信息</a></li>
					<li><a href="payway/getAllPayway.action"><span class="fa fa-caret-right"></span>支付方式信息列表</a></li>
					<li><a href="payway/queryPaywayByCond.action"><span class="fa fa-caret-right"></span>支付方式信息查询</a></li>
				</ul>
			</li>

			<li><a data-target=".legal-menu4" class="nav-header collapsed" data-toggle="collapse">产品类型信息管理<i
					class="fa fa-collapse"></i></a></li>
			<li>
				<ul class="legal-menu4 nav nav-list collapse">
					<li><a href="procate/createProcate.action"><span class="fa fa-caret-right"></span>新增产品类型信息</a></li>
					<li><a href="procate/getAllProcate.action"><span class="fa fa-caret-right"></span>产品类型信息列表</a></li>
					<li><a href="procate/queryProcateByCond.action"><span class="fa fa-caret-right"></span>产品类型信息查询</a></li>
				</ul>
			</li>

			<li><a data-target=".legal-menu5" class="nav-header collapsed" data-toggle="collapse">职位信息管理<i
					class="fa fa-collapse"></i></a></li>
			<li>
				<ul class="legal-menu5 nav nav-list collapse">
					<li><a href="duty/createDuty.action"><span class="fa fa-caret-right"></span>新增职位信息</a></li>
					<li><a href="duty/getAllDuty.action"><span class="fa fa-caret-right"></span>职位信息列表</a></li>
					<li><a href="duty/queryDutyByCond.action"><span class="fa fa-caret-right"></span>职位信息查询</a></li>
				</ul>
			</li>

			<li><a data-target=".legal-menu6" class="nav-header collapsed" data-toggle="collapse">服务类型信息管理<i
					class="fa fa-collapse"></i></a></li>
			<li>
				<ul class="legal-menu6 nav nav-list collapse">
					<li><a href="sercate/createSercate.action"><span class="fa fa-caret-right"></span>新增服务类型信息</a></li>
					<li><a href="sercate/getAllSercate.action"><span class="fa fa-caret-right"></span>服务类型信息列表</a></li>
					<li><a href="sercate/querySercateByCond.action"><span class="fa fa-caret-right"></span>服务类型信息查询</a></li>
				</ul>
			</li>


			<li><a data-target=".legal-menu12" class="nav-header collapsed" data-toggle="collapse">客户等级信息管理<i
					class="fa fa-collapse"></i></a></li>
			<li>
				<ul class="legal-menu12 nav nav-list collapse">
					<li><a href="ranks/createRanks.action"><span class="fa fa-caret-right"></span>新增客户等级信息</a></li>
					<li><a href="ranks/getAllRanks.action"><span class="fa fa-caret-right"></span>客户等级信息列表</a></li>
					<li><a href="ranks/queryRanksByCond.action"><span class="fa fa-caret-right"></span>客户等级信息查询</a></li>
				</ul>
			</li>

			<li><a data-target=".legal-menu13" class="nav-header collapsed" data-toggle="collapse">客户开发进度信息管理<i
					class="fa fa-collapse"></i></a></li>
			<li>
				<ul class="legal-menu13 nav nav-list collapse">
					<li><a href="schedule/createSchedule.action"><span class="fa fa-caret-right"></span>新增客户开发进度信息</a></li>
					<li><a href="schedule/getAllSchedule.action"><span class="fa fa-caret-right"></span>客户开发进度信息列表</a></li>
					<li><a href="schedule/queryScheduleByCond.action"><span class="fa fa-caret-right"></span>客户开发进度信息查询</a></li>
				</ul>
			</li>
		</c:if>

		<c:if test="${sessionScope.dutyname == '营销主管' || sessionScope.dutyname == '客户经理'}">
			<li><a data-target=".legal-menu2" class="nav-header collapsed" data-toggle="collapse">基础信息查询<i
					class="fa fa-collapse"></i></a></li>
			<li>
				<ul class="legal-menu2 nav nav-list collapse">
					<li><a href="soure/getAllSoure.action"><span class="fa fa-caret-right"></span>客户来源信息列表</a></li>
					<li><a href="payway/getAllPayway.action"><span class="fa fa-caret-right"></span>支付方式信息列表</a></li>
					<li><a href="procate/getAllProcate.action"><span class="fa fa-caret-right"></span>产品类型信息列表</a></li>
					<li><a href="sercate/getAllSercate.action"><span class="fa fa-caret-right"></span>服务类型信息列表</a></li>
					<li><a href="ranks/getAllRanks.action"><span class="fa fa-caret-right"></span>客户等级信息列表</a></li>
					<li><a href="schedule/getAllSchedule.action"><span class="fa fa-caret-right"></span>客户开发进度信息列表</a></li>
				</ul>
			</li>
		</c:if>



	</ul>
</div>

