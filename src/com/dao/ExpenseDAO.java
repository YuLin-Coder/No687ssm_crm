package com.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.entity.Expense;

@Repository("expenseDAO") // Repository标签定义数据库连接的访问 Spring中直接
public interface ExpenseDAO {

	/**
	 * ExpenseDAO 接口 可以按名称直接调用expense.xml配置文件的SQL语句
	 */

	// 插入数据 调用entity包expense.xml里的insertExpense配置 返回值0(失败),1(成功)
	public int insertExpense(Expense expense);

	// 更新数据 调用entity包expense.xml里的updateExpense配置 返回值0(失败),1(成功)
	public int updateExpense(Expense expense);

	// 删除数据 调用entity包expense.xml里的deleteExpense配置 返回值0(失败),1(成功)
	public int deleteExpense(String expenseid);

	// 查询全部数据 调用entity包expense.xml里的getAllExpense配置 返回List类型的数据
	public List<Expense> getAllExpense();

	// 按照Expense类里面的值精确查询 调用entity包expense.xml里的getExpenseByCond配置 返回List类型的数据
	public List<Expense> getExpenseByCond(Expense expense);

	// 按照Expense类里面的值模糊查询 调用entity包expense.xml里的getExpenseByLike配置 返回List类型的数据
	public List<Expense> getExpenseByLike(Expense expense);

	// 按主键查询表返回单一的Expense实例 调用entity包expense.xml里的getExpenseById配置
	public Expense getExpenseById(String expenseid);

}
