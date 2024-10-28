package com.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Customer;

@Service("customerService")
public interface CustomerService {
	// 插入数据 调用customerDAO里的insertCustomer配置
	public int insertCustomer(Customer customer);

	// 更新数据 调用customerDAO里的updateCustomer配置
	public int updateCustomer(Customer customer);

	// 删除数据 调用customerDAO里的deleteCustomer配置
	public int deleteCustomer(String customerid);

	// 查询全部数据 调用customerDAO里的getAllCustomer配置
	public List<Customer> getAllCustomer();

	// 按照Customer类里面的字段名称精确查询 调用customerDAO里的getCustomerByCond配置
	public List<Customer> getCustomerByCond(Customer customer);

	// 按照Customer类里面的字段名称模糊查询 调用customerDAO里的getCustomerByLike配置
	public List<Customer> getCustomerByLike(Customer customer);

	// 按主键查询表返回单一的Customer实例 调用customerDAO里的getCustomerById配置
	public Customer getCustomerById(String customerid);

}
