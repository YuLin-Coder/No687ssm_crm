package com.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.entity.Customer;

@Repository("customerDAO") // Repository标签定义数据库连接的访问 Spring中直接
public interface CustomerDAO {

	/**
	 * CustomerDAO 接口 可以按名称直接调用customer.xml配置文件的SQL语句
	 */

	// 插入数据 调用entity包customer.xml里的insertCustomer配置 返回值0(失败),1(成功)
	public int insertCustomer(Customer customer);

	// 更新数据 调用entity包customer.xml里的updateCustomer配置 返回值0(失败),1(成功)
	public int updateCustomer(Customer customer);

	// 删除数据 调用entity包customer.xml里的deleteCustomer配置 返回值0(失败),1(成功)
	public int deleteCustomer(String customerid);

	// 查询全部数据 调用entity包customer.xml里的getAllCustomer配置 返回List类型的数据
	public List<Customer> getAllCustomer();

	// 按照Customer类里面的值精确查询 调用entity包customer.xml里的getCustomerByCond配置
	// 返回List类型的数据
	public List<Customer> getCustomerByCond(Customer customer);

	// 按照Customer类里面的值模糊查询 调用entity包customer.xml里的getCustomerByLike配置
	// 返回List类型的数据
	public List<Customer> getCustomerByLike(Customer customer);

	// 按主键查询表返回单一的Customer实例 调用entity包customer.xml里的getCustomerById配置
	public Customer getCustomerById(String customerid);

}
