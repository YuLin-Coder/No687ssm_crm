package com.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.entity.Product;

@Repository("productDAO") // Repository标签定义数据库连接的访问 Spring中直接
public interface ProductDAO {

	/**
	 * ProductDAO 接口 可以按名称直接调用product.xml配置文件的SQL语句
	 */

	// 插入数据 调用entity包product.xml里的insertProduct配置 返回值0(失败),1(成功)
	public int insertProduct(Product product);

	// 更新数据 调用entity包product.xml里的updateProduct配置 返回值0(失败),1(成功)
	public int updateProduct(Product product);

	// 删除数据 调用entity包product.xml里的deleteProduct配置 返回值0(失败),1(成功)
	public int deleteProduct(String productid);

	// 查询全部数据 调用entity包product.xml里的getAllProduct配置 返回List类型的数据
	public List<Product> getAllProduct();

	// 按照Product类里面的值精确查询 调用entity包product.xml里的getProductByCond配置 返回List类型的数据
	public List<Product> getProductByCond(Product product);

	// 按照Product类里面的值模糊查询 调用entity包product.xml里的getProductByLike配置 返回List类型的数据
	public List<Product> getProductByLike(Product product);

	// 按主键查询表返回单一的Product实例 调用entity包product.xml里的getProductById配置
	public Product getProductById(String productid);

}
