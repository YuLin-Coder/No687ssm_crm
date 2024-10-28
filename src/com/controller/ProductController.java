package com.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Product;
import com.service.ProductService;
import com.entity.Procate;
import com.service.ProcateService;
import com.util.PageHelper;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/product", produces = "text/plain;charset=utf-8")
public class ProductController extends BaseController {
	// 注入Service 由于标签的存在 所以不需要getter setter
	@Autowired
	@Resource
	private ProductService productService;
	@Autowired
	@Resource
	private ProcateService procateService;

	// 准备添加数据
	@RequestMapping("createProduct.action")
	public String createProduct() {
		List<Procate> procateList = this.procateService.getAllProcate();
		this.getRequest().setAttribute("procateList", procateList);
		return "addproduct";
	}

	// 添加数据
	@RequestMapping("addProduct.action")
	public String addProduct(Product product) {
		product.setInventory("0");
		product.setNum("0");
		this.productService.insertProduct(product);
		return "redirect:/product/createProduct.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteProduct.action")
	public String deleteProduct(String id) {
		this.productService.deleteProduct(id);
		return "redirect:/product/getAllProduct.action";
	}

	// 批量删除数据
	@RequestMapping("deleteProductByIds.action")
	public String deleteProductByIds() {
		String[] ids = this.getRequest().getParameterValues("productid");
		for (String productid : ids) {
			this.productService.deleteProduct(productid);
		}
		return "redirect:/product/getAllProduct.action";
	}

	// 更新数据
	@RequestMapping("updateProduct.action")
	public String updateProduct(Product product) {
		this.productService.updateProduct(product);
		return "redirect:/product/getAllProduct.action";
	}

	// 显示全部数据
	@RequestMapping("getAllProduct.action")
	public String getAllProduct(String number) {
		List<Product> productList = this.productService.getAllProduct();
		PageHelper.getPage(productList, "product", null, null, 10, number, this.getRequest(), null);
		return "listproduct";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryProductByCond.action")
	public String queryProductByCond(String cond, String name, String number) {
		Product product = new Product();
		if (cond != null) {
			if ("procateid".equals(cond)) {
				product.setProcateid(name);
			}
			if ("productname".equals(cond)) {
				product.setProductname(name);
			}
			if ("details".equals(cond)) {
				product.setDetails(name);
			}
			if ("price".equals(cond)) {
				product.setPrice(name);
			}
			if ("inventory".equals(cond)) {
				product.setInventory(name);
			}
			if ("num".equals(cond)) {
				product.setNum(name);
			}
			if ("memo".equals(cond)) {
				product.setMemo(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.productService.getProductByLike(product), "product", nameList, valueList, 10, number,
				this.getRequest(), "query");
		name = null;
		cond = null;
		return "queryproduct";
	}

	// 按主键查询数据
	@RequestMapping("getProductById.action")
	public String getProductById(String id) {
		Product product = this.productService.getProductById(id);
		this.getRequest().setAttribute("product", product);
		List<Procate> procateList = this.procateService.getAllProcate();
		this.getRequest().setAttribute("procateList", procateList);
		return "editproduct";
	}

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

}
