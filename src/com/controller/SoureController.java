package com.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Soure;
import com.service.SoureService;
import com.util.PageHelper;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/soure", produces = "text/plain;charset=utf-8")
public class SoureController extends BaseController {
	// 注入Service 由于标签的存在 所以不需要getter setter
	@Autowired
	@Resource
	private SoureService soureService;

	// 准备添加数据
	@RequestMapping("createSoure.action")
	public String createSoure() {
		return "addsoure";
	}

	// 添加数据
	@RequestMapping("addSoure.action")
	public String addSoure(Soure soure) {
		this.soureService.insertSoure(soure);
		return "redirect:/soure/createSoure.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteSoure.action")
	public String deleteSoure(String id) {
		this.soureService.deleteSoure(id);
		return "redirect:/soure/getAllSoure.action";
	}

	// 批量删除数据
	@RequestMapping("deleteSoureByIds.action")
	public String deleteSoureByIds() {
		String[] ids = this.getRequest().getParameterValues("soureid");
		for (String soureid : ids) {
			this.soureService.deleteSoure(soureid);
		}
		return "redirect:/soure/getAllSoure.action";
	}

	// 更新数据
	@RequestMapping("updateSoure.action")
	public String updateSoure(Soure soure) {
		this.soureService.updateSoure(soure);
		return "redirect:/soure/getAllSoure.action";
	}

	// 显示全部数据
	@RequestMapping("getAllSoure.action")
	public String getAllSoure(String number) {
		List<Soure> soureList = this.soureService.getAllSoure();
		PageHelper.getPage(soureList, "soure", null, null, 10, number, this.getRequest(), null);
		return "listsoure";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("querySoureByCond.action")
	public String querySoureByCond(String cond, String name, String number) {
		Soure soure = new Soure();
		if (cond != null) {
			if ("sourename".equals(cond)) {
				soure.setSourename(name);
			}
			if ("details".equals(cond)) {
				soure.setDetails(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.soureService.getSoureByLike(soure), "soure", nameList, valueList, 10, number,
				this.getRequest(), "query");
		name = null;
		cond = null;
		return "querysoure";
	}

	// 按主键查询数据
	@RequestMapping("getSoureById.action")
	public String getSoureById(String id) {
		Soure soure = this.soureService.getSoureById(id);
		this.getRequest().setAttribute("soure", soure);
		return "editsoure";
	}

	public SoureService getSoureService() {
		return soureService;
	}

	public void setSoureService(SoureService soureService) {
		this.soureService = soureService;
	}

}
