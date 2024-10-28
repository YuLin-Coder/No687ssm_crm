package com.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.ProductDAO;
import com.entity.Product;
import com.service.ProductService;

@Service("productService")
public class ProductServiceImpl implements ProductService {
	@Autowired
	@Resource
	private ProductDAO productDAO;

	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertProduct(Product product) {
		return this.productDAO.insertProduct(product);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateProduct(Product product) {
		return this.productDAO.updateProduct(product);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteProduct(String productid) {
		return this.productDAO.deleteProduct(productid);
	}

	@Override // 继承接口的查询全部
	public List<Product> getAllProduct() {
		return this.productDAO.getAllProduct();
	}

	@Override // 继承接口的按条件精确查询
	public List<Product> getProductByCond(Product product) {
		return this.productDAO.getProductByCond(product);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Product> getProductByLike(Product product) {
		return this.productDAO.getProductByLike(product);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Product getProductById(String productid) {
		return this.productDAO.getProductById(productid);
	}

}
