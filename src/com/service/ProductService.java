package com.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Product;

@Service("productService")
public interface ProductService {
	// 插入数据 调用productDAO里的insertProduct配置
	public int insertProduct(Product product);

	// 更新数据 调用productDAO里的updateProduct配置
	public int updateProduct(Product product);

	// 删除数据 调用productDAO里的deleteProduct配置
	public int deleteProduct(String productid);

	// 查询全部数据 调用productDAO里的getAllProduct配置
	public List<Product> getAllProduct();

	// 按照Product类里面的字段名称精确查询 调用productDAO里的getProductByCond配置
	public List<Product> getProductByCond(Product product);

	// 按照Product类里面的字段名称模糊查询 调用productDAO里的getProductByLike配置
	public List<Product> getProductByLike(Product product);

	// 按主键查询表返回单一的Product实例 调用productDAO里的getProductById配置
	public Product getProductById(String productid);

}
