package com.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Duty;
import com.service.DutyService;
import com.util.PageHelper;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/duty", produces = "text/plain;charset=utf-8")
public class DutyController extends BaseController {
	// 注入Service 由于标签的存在 所以不需要getter setter
	@Autowired
	@Resource
	private DutyService dutyService;

	// 准备添加数据
	@RequestMapping("createDuty.action")
	public String createDuty() {
		return "addduty";
	}

	// 添加数据
	@RequestMapping("addDuty.action")
	public String addDuty(Duty duty) {
		this.dutyService.insertDuty(duty);
		return "redirect:/duty/createDuty.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteDuty.action")
	public String deleteDuty(String id) {
		this.dutyService.deleteDuty(id);
		return "redirect:/duty/getAllDuty.action";
	}

	// 批量删除数据
	@RequestMapping("deleteDutyByIds.action")
	public String deleteDutyByIds() {
		String[] ids = this.getRequest().getParameterValues("dutyid");
		for (String dutyid : ids) {
			this.dutyService.deleteDuty(dutyid);
		}
		return "redirect:/duty/getAllDuty.action";
	}

	// 更新数据
	@RequestMapping("updateDuty.action")
	public String updateDuty(Duty duty) {
		this.dutyService.updateDuty(duty);
		return "redirect:/duty/getAllDuty.action";
	}

	// 显示全部数据
	@RequestMapping("getAllDuty.action")
	public String getAllDuty(String number) {
		List<Duty> dutyList = this.dutyService.getAllDuty();
		PageHelper.getPage(dutyList, "duty", null, null, 10, number, this.getRequest(), null);
		return "listduty";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryDutyByCond.action")
	public String queryDutyByCond(String cond, String name, String number) {
		Duty duty = new Duty();
		if (cond != null) {
			if ("dutyname".equals(cond)) {
				duty.setDutyname(name);
			}
			if ("details".equals(cond)) {
				duty.setDetails(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.dutyService.getDutyByLike(duty), "duty", nameList, valueList, 10, number,
				this.getRequest(), "query");
		name = null;
		cond = null;
		return "queryduty";
	}

	// 按主键查询数据
	@RequestMapping("getDutyById.action")
	public String getDutyById(String id) {
		Duty duty = this.dutyService.getDutyById(id);
		this.getRequest().setAttribute("duty", duty);
		return "editduty";
	}

	public DutyService getDutyService() {
		return dutyService;
	}

	public void setDutyService(DutyService dutyService) {
		this.dutyService = dutyService;
	}

}
