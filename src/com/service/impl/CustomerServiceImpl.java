package com.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.CustomerDAO;
import com.entity.Customer;
import com.service.CustomerService;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	@Resource
	private CustomerDAO customerDAO;

	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertCustomer(Customer customer) {
		return this.customerDAO.insertCustomer(customer);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateCustomer(Customer customer) {
		return this.customerDAO.updateCustomer(customer);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteCustomer(String customerid) {
		return this.customerDAO.deleteCustomer(customerid);
	}

	@Override // 继承接口的查询全部
	public List<Customer> getAllCustomer() {
		return this.customerDAO.getAllCustomer();
	}

	@Override // 继承接口的按条件精确查询
	public List<Customer> getCustomerByCond(Customer customer) {
		return this.customerDAO.getCustomerByCond(customer);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Customer> getCustomerByLike(Customer customer) {
		return this.customerDAO.getCustomerByLike(customer);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Customer getCustomerById(String customerid) {
		return this.customerDAO.getCustomerById(customerid);
	}

}
