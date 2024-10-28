package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Customer;
import com.entity.Expense;
import com.entity.Payway;
import com.entity.Product;
import com.service.CustomerService;
import com.service.ExpenseService;
import com.service.PaywayService;
import com.service.ProductService;
import com.util.PageHelper;
import com.util.VeDate;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/expense", produces = "text/plain;charset=utf-8")
public class ExpenseController extends BaseController {
	// 注入Service 由于标签的存在 所以不需要getter setter
	@Autowired
	@Resource
	private ExpenseService expenseService;
	@Autowired
	@Resource
	private ProductService productService;
	@Autowired
	@Resource
	private CustomerService customerService;
	@Autowired
	@Resource
	private PaywayService paywayService;

	// 准备添加数据
	@RequestMapping("createExpense.action")
	public String createExpense() {
		List<Product> productList = this.productService.getAllProduct();
		this.getRequest().setAttribute("productList", productList);
		List<Customer> customerList = this.customerService.getAllCustomer();
		this.getRequest().setAttribute("customerList", customerList);
		List<Payway> paywayList = this.paywayService.getAllPayway();
		this.getRequest().setAttribute("paywayList", paywayList);
		return "addexpense";
	}

	// 添加数据
	@RequestMapping("addExpense.action")
	public String addExpense(Expense expense) {
		expense.setAdminid((String)this.getSession().getAttribute("adminid"));
		Product product = this.productService.getProductById(expense.getProductid());
		expense.setPrice(product.getPrice());
		int n = Integer.parseInt(expense.getNum()) + Integer.parseInt(product.getNum());
		int i = Integer.parseInt(product.getInventory()) - Integer.parseInt(expense.getNum());
		product.setNum("" + n);
		product.setInventory("" + i);
		Customer customer = this.customerService.getCustomerById(expense.getCustomerid());
		Double cjf = Double.parseDouble(customer.getIntegral());
		Double jf = (Double.parseDouble(product.getPrice()) * Integer.parseInt(expense.getNum()))/100;
		customer.setIntegral(VeDate.doubleString(cjf + jf));
		this.expenseService.insertExpense(expense);
		this.customerService.updateCustomer(customer);
		this.productService.updateProduct(product);
		return "redirect:/expense/createExpense.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteExpense.action")
	public String deleteExpense(String id) {
		this.expenseService.deleteExpense(id);
		return "redirect:/expense/getAllExpense.action";
	}

	// 批量删除数据
	@RequestMapping("deleteExpenseByIds.action")
	public String deleteExpenseByIds() {
		String[] ids = this.getRequest().getParameterValues("expenseid");
		for (String expenseid : ids) {
			this.expenseService.deleteExpense(expenseid);
		}
		return "redirect:/expense/getAllExpense.action";
	}

	// 更新数据
	@RequestMapping("updateExpense.action")
	public String updateExpense(Expense expense) {
		this.expenseService.updateExpense(expense);
		return "redirect:/expense/getAllExpense.action";
	}

	// 显示全部数据
	@RequestMapping("getAllExpense.action")
	public String getAllExpense(String number) {
		List<Expense> expenseList = this.expenseService.getAllExpense();
		PageHelper.getPage(expenseList, "expense", null, null, 10, number, this.getRequest(), null);
		return "listexpense";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryExpenseByCond.action")
	public String queryExpenseByCond(String cond, String name, String number) {
		Expense expense = new Expense();
		if (cond != null) {
			if ("username".equals(cond)) {
				expense.setUsername(name);;
			}
			if ("realname".equals(cond)) {
				expense.setRealname(name);;
			}
			if ("productname".equals(cond)) {
				expense.setProductname(name);;
			}
			
			if ("price".equals(cond)) {
				expense.setPrice(name);
			}
			if ("num".equals(cond)) {
				expense.setNum(name);
			}
			if ("wayname".equals(cond)) {
				expense.setWayname(name);;
			}
			if ("memo".equals(cond)) {
				expense.setMemo(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.expenseService.getExpenseByLike(expense), "expense", nameList, valueList, 10, number,
				this.getRequest(), "query");
		name = null;
		cond = null;
		return "queryexpense";
	}

	// 按主键查询数据
	@RequestMapping("getExpenseById.action")
	public String getExpenseById(String id) {
		Expense expense = this.expenseService.getExpenseById(id);
		List<Product> productList = this.productService.getAllProduct();
		this.getRequest().setAttribute("productList", productList);
		List<Customer> customerList = this.customerService.getAllCustomer();
		this.getRequest().setAttribute("customerList", customerList);
		List<Payway> paywayList = this.paywayService.getAllPayway();
		this.getRequest().setAttribute("paywayList", paywayList);
		this.getRequest().setAttribute("expense", expense);
		return "editexpense";
	}

	public ExpenseService getExpenseService() {
		return expenseService;
	}

	public void setExpenseService(ExpenseService expenseService) {
		this.expenseService = expenseService;
	}

}
