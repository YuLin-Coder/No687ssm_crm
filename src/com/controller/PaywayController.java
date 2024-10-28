package com.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Payway;
import com.service.PaywayService;
import com.util.PageHelper;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/payway", produces = "text/plain;charset=utf-8")
public class PaywayController extends BaseController {
	// 注入Service 由于标签的存在 所以不需要getter setter
	@Autowired
	@Resource
	private PaywayService paywayService;

	// 准备添加数据
	@RequestMapping("createPayway.action")
	public String createPayway() {
		return "addpayway";
	}

	// 添加数据
	@RequestMapping("addPayway.action")
	public String addPayway(Payway payway) {
		this.paywayService.insertPayway(payway);
		return "redirect:/payway/createPayway.action";
	}

	// 通过主键删除数据
	@RequestMapping("deletePayway.action")
	public String deletePayway(String id) {
		this.paywayService.deletePayway(id);
		return "redirect:/payway/getAllPayway.action";
	}

	// 批量删除数据
	@RequestMapping("deletePaywayByIds.action")
	public String deletePaywayByIds() {
		String[] ids = this.getRequest().getParameterValues("paywayid");
		for (String paywayid : ids) {
			this.paywayService.deletePayway(paywayid);
		}
		return "redirect:/payway/getAllPayway.action";
	}

	// 更新数据
	@RequestMapping("updatePayway.action")
	public String updatePayway(Payway payway) {
		this.paywayService.updatePayway(payway);
		return "redirect:/payway/getAllPayway.action";
	}

	// 显示全部数据
	@RequestMapping("getAllPayway.action")
	public String getAllPayway(String number) {
		List<Payway> paywayList = this.paywayService.getAllPayway();
		PageHelper.getPage(paywayList, "payway", null, null, 10, number, this.getRequest(), null);
		return "listpayway";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryPaywayByCond.action")
	public String queryPaywayByCond(String cond, String name, String number) {
		Payway payway = new Payway();
		if (cond != null) {
			if ("wayname".equals(cond)) {
				payway.setWayname(name);
			}
			if ("payee".equals(cond)) {
				payway.setPayee(name);
			}
			if ("memo".equals(cond)) {
				payway.setMemo(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.paywayService.getPaywayByLike(payway), "payway", nameList, valueList, 10, number,
				this.getRequest(), "query");
		name = null;
		cond = null;
		return "querypayway";
	}

	// 按主键查询数据
	@RequestMapping("getPaywayById.action")
	public String getPaywayById(String id) {
		Payway payway = this.paywayService.getPaywayById(id);
		this.getRequest().setAttribute("payway", payway);
		return "editpayway";
	}

	public PaywayService getPaywayService() {
		return paywayService;
	}

	public void setPaywayService(PaywayService paywayService) {
		this.paywayService = paywayService;
	}

}
