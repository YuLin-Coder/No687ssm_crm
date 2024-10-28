package com.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Ranks;
import com.service.RanksService;
import com.util.PageHelper;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/ranks", produces = "text/plain;charset=utf-8")
public class RanksController extends BaseController {
	// 注入Service 由于标签的存在 所以不需要getter setter
	@Autowired
	@Resource
	private RanksService ranksService;

	// 准备添加数据
	@RequestMapping("createRanks.action")
	public String createRanks() {
		return "addranks";
	}

	// 添加数据
	@RequestMapping("addRanks.action")
	public String addRanks(Ranks ranks) {
		this.ranksService.insertRanks(ranks);
		return "redirect:/ranks/createRanks.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteRanks.action")
	public String deleteRanks(String id) {
		this.ranksService.deleteRanks(id);
		return "redirect:/ranks/getAllRanks.action";
	}

	// 批量删除数据
	@RequestMapping("deleteRanksByIds.action")
	public String deleteRanksByIds() {
		String[] ids = this.getRequest().getParameterValues("ranksid");
		for (String ranksid : ids) {
			this.ranksService.deleteRanks(ranksid);
		}
		return "redirect:/ranks/getAllRanks.action";
	}

	// 更新数据
	@RequestMapping("updateRanks.action")
	public String updateRanks(Ranks ranks) {
		this.ranksService.updateRanks(ranks);
		return "redirect:/ranks/getAllRanks.action";
	}

	// 显示全部数据
	@RequestMapping("getAllRanks.action")
	public String getAllRanks(String number) {
		List<Ranks> ranksList = this.ranksService.getAllRanks();
		PageHelper.getPage(ranksList, "ranks", null, null, 10, number, this.getRequest(), null);
		return "listranks";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryRanksByCond.action")
	public String queryRanksByCond(String cond, String name, String number) {
		Ranks ranks = new Ranks();
		if (cond != null) {
			if ("ranksname".equals(cond)) {
				ranks.setRanksname(name);
			}
			if ("details".equals(cond)) {
				ranks.setDetails(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.ranksService.getRanksByLike(ranks), "ranks", nameList, valueList, 10, number,
				this.getRequest(), "query");
		name = null;
		cond = null;
		return "queryranks";
	}

	// 按主键查询数据
	@RequestMapping("getRanksById.action")
	public String getRanksById(String id) {
		Ranks ranks = this.ranksService.getRanksById(id);
		this.getRequest().setAttribute("ranks", ranks);
		return "editranks";
	}

	public RanksService getRanksService() {
		return ranksService;
	}

	public void setRanksService(RanksService ranksService) {
		this.ranksService = ranksService;
	}

}
