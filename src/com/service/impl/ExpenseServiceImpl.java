package com.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ExpenseDAO;
import com.entity.Expense;
import com.service.ExpenseService;

@Service("expenseService")
public class ExpenseServiceImpl implements ExpenseService {
	@Autowired
	@Resource
	private ExpenseDAO expenseDAO;

	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertExpense(Expense expense) {
		return this.expenseDAO.insertExpense(expense);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateExpense(Expense expense) {
		return this.expenseDAO.updateExpense(expense);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteExpense(String expenseid) {
		return this.expenseDAO.deleteExpense(expenseid);
	}

	@Override // 继承接口的查询全部
	public List<Expense> getAllExpense() {
		return this.expenseDAO.getAllExpense();
	}

	@Override // 继承接口的按条件精确查询
	public List<Expense> getExpenseByCond(Expense expense) {
		return this.expenseDAO.getExpenseByCond(expense);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Expense> getExpenseByLike(Expense expense) {
		return this.expenseDAO.getExpenseByLike(expense);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Expense getExpenseById(String expenseid) {
		return this.expenseDAO.getExpenseById(expenseid);
	}

}
