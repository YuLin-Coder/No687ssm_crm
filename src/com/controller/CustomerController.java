package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Admin;
import com.entity.Customer;
import com.entity.Ranks;
import com.entity.Schedule;
import com.entity.Soure;
import com.service.AdminService;
import com.service.CustomerService;
import com.service.RanksService;
import com.service.ScheduleService;
import com.service.SoureService;
import com.util.PageHelper;
import com.util.VeDate;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/customer", produces = "text/plain;charset=utf-8")
public class CustomerController extends BaseController {
	// 注入Service 由于标签的存在 所以不需要getter setter
	@Autowired
	@Resource
	private CustomerService customerService;
	@Autowired
	@Resource
	private SoureService soureService;
	@Autowired
	@Resource
	private AdminService adminService;
	@Autowired
	@Resource
	private RanksService ranksService;
	@Autowired
	@Resource
	private ScheduleService scheduleService;

	// 准备添加数据
	@RequestMapping("createCustomer.action")
	public String createCustomer() {
		List<Soure> soureList = this.soureService.getAllSoure();
		this.getRequest().setAttribute("soureList", soureList);
		List<Admin> adminList = this.adminService.getAllAdmin();
		this.getRequest().setAttribute("adminList", adminList);
		List<Ranks> ranksList = this.ranksService.getAllRanks();
		this.getRequest().setAttribute("ranksList", ranksList);
		List<Schedule> scheduleList = this.scheduleService.getAllSchedule();
		this.getRequest().setAttribute("scheduleList", scheduleList);
		return "addcustomer";
	}

	// 添加数据
	@RequestMapping("addCustomer.action")
	public String addCustomer(Customer customer) {
		customer.setAdminid((String) this.getSession().getAttribute("adminid"));
		customer.setIntegral("0");
		customer.setCustypeid("-");
		customer.setExpenseid("-");
		customer.setPlan("-");
		customer.setServeid("-");
		customer.setAddtime(VeDate.getStringDateShort());
		this.customerService.insertCustomer(customer);
		return "redirect:/customer/createCustomer.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteCustomer.action")
	public String deleteCustomer(String id) {
		this.customerService.deleteCustomer(id);
		return "redirect:/customer/getAllCustomer.action";
	}

	// 批量删除数据
	@RequestMapping("deleteCustomerByIds.action")
	public String deleteCustomerByIds() {
		String[] ids = this.getRequest().getParameterValues("customerid");
		for (String customerid : ids) {
			this.customerService.deleteCustomer(customerid);
		}
		return "redirect:/customer/getAllCustomer.action";
	}

	// 更新数据
	@RequestMapping("updateCustomer.action")
	public String updateCustomer(Customer customer) {
		this.customerService.updateCustomer(customer);
		return "redirect:/customer/getAllCustomer.action";
	}

	// 显示全部数据
	@RequestMapping("getAllCustomer.action")
	public String getAllCustomer(String number) {
		List<Customer> tempList = this.customerService.getAllCustomer();
		List<Customer> customerList = new ArrayList<Customer>();
		for(int i = 0  ; i < tempList.size() ; i++){
			Customer u = tempList.get(i);
			if("准客户".equals(u.getRanksname())){
				
			} else {
				u.setSchedulename("-");
				u.setPlan("-");
			}
			customerList.add(u);
		}
		PageHelper.getPage(customerList, "customer", null, null, 10, number, this.getRequest(), null);
		return "listcustomer";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryCustomerByCond.action")
	public String queryCustomerByCond(String cond, String name, String number) {
		Customer customer = new Customer();
		if (cond != null) {
			if ("realname".equals(cond)) {
				customer.setRealname(name);
			}
			if ("nickname".equals(cond)) {
				customer.setNickname(name);
			}
			if ("tel".equals(cond)) {
				customer.setTel(name);
			}
			if ("qq".equals(cond)) {
				customer.setQq(name);
			}
			if ("wechat".equals(cond)) {
				customer.setWechat(name);
			}
			if ("sex".equals(cond)) {
				customer.setSex(name);
			}
			if ("birthday".equals(cond)) {
				customer.setBirthday(name);
			}
			if ("sourename".equals(cond)) {
				customer.setSourename(name);;
			}
			if ("addtime".equals(cond)) {
				customer.setAddtime(name);
			}
			if ("username".equals(cond)) {
				customer.setUsername(name);;
			}
			if ("integral".equals(cond)) {
				customer.setIntegral(name);
			}
			if ("ranksname".equals(cond)) {
				customer.setRanksname(name);;
			}
			if ("schedulename".equals(cond)) {
				customer.setSchedulename(name);
			}
			if ("plan".equals(cond)) {
				customer.setPlan(name);
			}
			if ("memo".equals(cond)) {
				customer.setMemo(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		
		PageHelper.getPage(this.customerService.getCustomerByLike(customer), "customer", nameList, valueList, 10,
				number, this.getRequest(), "query");
		name = null;
		cond = null;
		return "querycustomer";
	}

	// 按主键查询数据
	@RequestMapping("getCustomerById.action")
	public String getCustomerById(String id) {
		Customer customer = this.customerService.getCustomerById(id);
		this.getRequest().setAttribute("customer", customer);
		List<Soure> soureList = this.soureService.getAllSoure();
		this.getRequest().setAttribute("soureList", soureList);
		List<Admin> adminList = this.adminService.getAllAdmin();
		this.getRequest().setAttribute("adminList", adminList);
		List<Ranks> ranksList = this.ranksService.getAllRanks();
		this.getRequest().setAttribute("ranksList", ranksList);
		List<Schedule> scheduleList = this.scheduleService.getAllSchedule();
		this.getRequest().setAttribute("scheduleList", scheduleList);
		return "editcustomer";
	}

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

}
