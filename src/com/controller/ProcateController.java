package com.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Procate;
import com.service.ProcateService;
import com.util.PageHelper;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/procate", produces = "text/plain;charset=utf-8")
public class ProcateController extends BaseController {
	// 注入Service 由于标签的存在 所以不需要getter setter
	@Autowired
	@Resource
	private ProcateService procateService;

	// 准备添加数据
	@RequestMapping("createProcate.action")
	public String createProcate() {
		return "addprocate";
	}

	// 添加数据
	@RequestMapping("addProcate.action")
	public String addProcate(Procate procate) {
		this.procateService.insertProcate(procate);
		return "redirect:/procate/createProcate.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteProcate.action")
	public String deleteProcate(String id) {
		this.procateService.deleteProcate(id);
		return "redirect:/procate/getAllProcate.action";
	}

	// 批量删除数据
	@RequestMapping("deleteProcateByIds.action")
	public String deleteProcateByIds() {
		String[] ids = this.getRequest().getParameterValues("procateid");
		for (String procateid : ids) {
			this.procateService.deleteProcate(procateid);
		}
		return "redirect:/procate/getAllProcate.action";
	}

	// 更新数据
	@RequestMapping("updateProcate.action")
	public String updateProcate(Procate procate) {
		this.procateService.updateProcate(procate);
		return "redirect:/procate/getAllProcate.action";
	}

	// 显示全部数据
	@RequestMapping("getAllProcate.action")
	public String getAllProcate(String number) {
		List<Procate> procateList = this.procateService.getAllProcate();
		PageHelper.getPage(procateList, "procate", null, null, 10, number, this.getRequest(), null);
		return "listprocate";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryProcateByCond.action")
	public String queryProcateByCond(String cond, String name, String number) {
		Procate procate = new Procate();
		if (cond != null) {
			if ("procatename".equals(cond)) {
				procate.setProcatename(name);
			}
			if ("details".equals(cond)) {
				procate.setDetails(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.procateService.getProcateByLike(procate), "procate", nameList, valueList, 10, number,
				this.getRequest(), "query");
		name = null;
		cond = null;
		return "queryprocate";
	}

	// 按主键查询数据
	@RequestMapping("getProcateById.action")
	public String getProcateById(String id) {
		Procate procate = this.procateService.getProcateById(id);
		this.getRequest().setAttribute("procate", procate);
		return "editprocate";
	}

	public ProcateService getProcateService() {
		return procateService;
	}

	public void setProcateService(ProcateService procateService) {
		this.procateService = procateService;
	}

}
