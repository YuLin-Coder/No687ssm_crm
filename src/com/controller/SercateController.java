package com.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Sercate;
import com.service.SercateService;
import com.util.PageHelper;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/sercate", produces = "text/plain;charset=utf-8")
public class SercateController extends BaseController {
	// 注入Service 由于标签的存在 所以不需要getter setter
	@Autowired
	@Resource
	private SercateService sercateService;

	// 准备添加数据
	@RequestMapping("createSercate.action")
	public String createSercate() {
		return "addsercate";
	}

	// 添加数据
	@RequestMapping("addSercate.action")
	public String addSercate(Sercate sercate) {
		this.sercateService.insertSercate(sercate);
		return "redirect:/sercate/createSercate.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteSercate.action")
	public String deleteSercate(String id) {
		this.sercateService.deleteSercate(id);
		return "redirect:/sercate/getAllSercate.action";
	}

	// 批量删除数据
	@RequestMapping("deleteSercateByIds.action")
	public String deleteSercateByIds() {
		String[] ids = this.getRequest().getParameterValues("sercateid");
		for (String sercateid : ids) {
			this.sercateService.deleteSercate(sercateid);
		}
		return "redirect:/sercate/getAllSercate.action";
	}

	// 更新数据
	@RequestMapping("updateSercate.action")
	public String updateSercate(Sercate sercate) {
		this.sercateService.updateSercate(sercate);
		return "redirect:/sercate/getAllSercate.action";
	}

	// 显示全部数据
	@RequestMapping("getAllSercate.action")
	public String getAllSercate(String number) {
		List<Sercate> sercateList = this.sercateService.getAllSercate();
		PageHelper.getPage(sercateList, "sercate", null, null, 10, number, this.getRequest(), null);
		return "listsercate";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("querySercateByCond.action")
	public String querySercateByCond(String cond, String name, String number) {
		Sercate sercate = new Sercate();
		if (cond != null) {
			if ("cercatename".equals(cond)) {
				sercate.setCercatename(name);
			}
			if ("details".equals(cond)) {
				sercate.setDetails(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.sercateService.getSercateByLike(sercate), "sercate", nameList, valueList, 10, number,
				this.getRequest(), "query");
		name = null;
		cond = null;
		return "querysercate";
	}

	// 按主键查询数据
	@RequestMapping("getSercateById.action")
	public String getSercateById(String id) {
		Sercate sercate = this.sercateService.getSercateById(id);
		this.getRequest().setAttribute("sercate", sercate);
		return "editsercate";
	}

	public SercateService getSercateService() {
		return sercateService;
	}

	public void setSercateService(SercateService sercateService) {
		this.sercateService = sercateService;
	}

}
