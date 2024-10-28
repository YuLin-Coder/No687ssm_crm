package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.entity.Expense;

@Service("expenseSevice")
public interface ExpenseService {
	// 插入数据 调用enpenseDAO里的insertExpense配置
	public int insertExpense(Expense expense);

	// 更新数据 调用enpenseDAO里的updateExpense配置
	public int updateExpense(Expense expense);

	// 删除数据 调用enpenseDAO里的deleteExpense配置
	public int deleteExpense(String expenseid);

	// 查询全部数据 调用enpenseDAO里的getAllExpense配置
	public List<Expense> getAllExpense();

	// 按照Expense类里面的字段名称精确查询 调用enpenseDAO里的getExpenseByCond配置
	public List<Expense> getExpenseByCond(Expense expense);

	// 按照Expense类里面的字段名称模糊查询 调用enpenseDAO里的getExpenseByLike配置
	public List<Expense> getExpenseByLike(Expense expense);

	// 按主键查询表返回单一的Expense实例 调用enpenseDAO里的getExpenseById配置
	public Expense getExpenseById(String expenseid);

}
