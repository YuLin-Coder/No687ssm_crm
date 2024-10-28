package com.controller;

import java.util.List;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.Customer;
import com.entity.Expense;
import com.entity.Payway;
import com.entity.Ranks;
import com.service.CustomerService;
import com.service.ExpenseService;
import com.service.PaywayService;
import com.service.RanksService;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/chart", produces = "text/plain;charset=utf-8")
public class ChartController extends BaseController {
	@Autowired
	@Resource
	private CustomerService customerService;
	@Autowired
	@Resource
	private RanksService ranksService;
	@Autowired
	@Resource
	private ExpenseService expenseService;
	@Autowired
	@Resource
	private PaywayService paywayService;

	@RequestMapping("chartBar.action")
	@ResponseBody
	public String chartBar() throws JSONException {// 客户信息分析
		List<Ranks> rankList = this.ranksService.getAllRanks();
		JSONObject json = new JSONObject();
		JSONArray cate = new JSONArray();
		JSONArray count = new JSONArray();
		for (Ranks rank : rankList) {
			cate.put(rank.getRanksname());
			Customer cus = new Customer();
			cus.setRanksid(rank.getRanksid());
			List<Customer> list = this.customerService.getCustomerByCond(cus);
			count.put(list.size());
		}
		json.put("count", count.toString());
		json.put("cate", cate.toString().replaceAll("\"", ""));
		return json.toString();
	}

	@RequestMapping("chartPie.action")
	@ResponseBody
	public String chartPie() throws JSONException {// 交易记录分析
		List<Payway> list = this.paywayService.getAllPayway();
		JSONObject json = new JSONObject();
		JSONArray names = new JSONArray();
		JSONArray count = new JSONArray();
		for (Payway way : list) {
			names.put(way.getWayname());
			double total = 0;
			Expense ex = new Expense();
			ex.setPaywayid(way.getPaywayid());
			List<Expense> exList = this.expenseService.getExpenseByCond(ex);
			for (Expense x : exList) {
				total += Double.parseDouble(x.getNum());
			}
			count.put(total);
		}
		json.put("count", count.toString());
		json.put("names", names.toString().replaceAll("\"", ""));
		System.out.println(json.toString());
		return json.toString();
	}
}
