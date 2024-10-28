package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Admin;
import com.entity.Customer;
import com.entity.Product;
import com.entity.Sercate;
import com.entity.Serve;
import com.service.AdminService;
import com.service.CustomerService;
import com.service.ProductService;
import com.service.SercateService;
import com.service.ServeService;
import com.util.PageHelper;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/serve", produces = "text/plain;charset=utf-8")
public class ServeController extends BaseController {
	// 注入Service 由于标签的存在 所以不需要getter setter
	@Autowired
	@Resource
	private ServeService serveService;
	@Autowired
	@Resource
	private SercateService sercateService;
	@Autowired
	@Resource
	private ProductService productService;
	@Autowired
	@Resource
	private CustomerService customerService;
	@Autowired
	@Resource
	private AdminService adminService;

	// 准备添加数据
	@RequestMapping("createServe.action")
	public String createServe() {
		List<Sercate> sercateList = this.sercateService.getAllSercate();
		this.getRequest().setAttribute("sercateList", sercateList);
		List<Product> productList = this.productService.getAllProduct();
		this.getRequest().setAttribute("productList", productList);
		List<Customer> customerList = this.customerService.getAllCustomer();
		this.getRequest().setAttribute("customerList", customerList);
		List<Admin> adminList = this.adminService.getAllAdmin();
		this.getRequest().setAttribute("adminList", adminList);
		return "addserve";
	}

	// 添加数据
	@RequestMapping("addServe.action")
	public String addServe(Serve serve) {
		serve.setConclusion("待处理");
		this.serveService.insertServe(serve);
		return "redirect:/serve/createServe.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteServe.action")
	public String deleteServe(String id) {
		this.serveService.deleteServe(id);
		return "redirect:/serve/getAllServe.action";
	}

	// 批量删除数据
	@RequestMapping("deleteServeByIds.action")
	public String deleteServeByIds() {
		String[] ids = this.getRequest().getParameterValues("serveid");
		for (String serveid : ids) {
			this.serveService.deleteServe(serveid);
		}
		return "redirect:/serve/getAllServe.action";
	}

	// 更新数据
	@RequestMapping("updateServe.action")
	public String updateServe(Serve serve) {
		this.serveService.updateServe(serve);
		return "redirect:/serve/getAllServe.action";
	}

	// 显示全部数据
	@RequestMapping("getAllServe.action")
	public String getAllServe(String number) {
		List<Serve> serveList = this.serveService.getAllServe();
		PageHelper.getPage(serveList, "serve", null, null, 10, number, this.getRequest(), null);
		return "listserve";
	}

	// 显示自己相关数据
	@RequestMapping("getMyServe.action")
	public String getMyServe(String number) {
		Serve serve = new Serve();
		serve.setAdminid((String) this.getSession().getAttribute("adminid"));
		List<Serve> serveList = this.serveService.getServeByLike(serve);
		PageHelper.getPage(serveList, "serve", null, null, 10, number, this.getRequest(), null);
		return "listserve";
	}

	// 显示自己相关的未处理数据
	@RequestMapping("getMyReServe.action")
	public String getMyReServe(String number) {
		Serve serve = new Serve();
		serve.setAdminid((String) this.getSession().getAttribute("adminid"));
		serve.setConclusion("待处理");
		List<Serve> serveList = this.serveService.getServeByLike(serve);
		PageHelper.getPage(serveList, "serve", null, null, 10, number, this.getRequest(), null);
		return "listserve";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryServeByCond.action")
	public String queryServeByCond(String cond, String name, String number) {
		Serve serve = new Serve();
		if (cond != null) {
			if ("sercateid".equals(cond)) {
				serve.setSercateid(name);
			}
			if ("productname".equals(cond)) {
				serve.setProductname(name);;
			}
			if ("realname".equals(cond)) {
				serve.setRealname(name);;
			}
			if ("username".equals(cond)) {
				serve.setUsername(name);;
			}
			if ("content".equals(cond)) {
				serve.setContent(name);
			}
			if ("conclusion".equals(cond)) {
				serve.setConclusion(name);
			}
			if ("memo".equals(cond)) {
				serve.setMemo(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.serveService.getServeByLike(serve), "serve", nameList, valueList, 10, number,
				this.getRequest(), "query");
		name = null;
		cond = null;
		return "queryserve";
	}

	// 按主键查询数据
	@RequestMapping("getServeById.action")
	public String getServeById(String id) {
		Serve serve = this.serveService.getServeById(id);
		this.getRequest().setAttribute("serve", serve);
		List<Sercate> sercateList = this.sercateService.getAllSercate();
		this.getRequest().setAttribute("sercateList", sercateList);
		List<Product> productList = this.productService.getAllProduct();
		this.getRequest().setAttribute("productList", productList);
		List<Customer> customerList = this.customerService.getAllCustomer();
		this.getRequest().setAttribute("customerList", customerList);
		List<Admin> adminList = this.adminService.getAllAdmin();
		this.getRequest().setAttribute("adminList", adminList);
		return "editserve";
	}

	public ServeService getServeService() {
		return serveService;
	}

	public void setServeService(ServeService serveService) {
		this.serveService = serveService;
	}

}
