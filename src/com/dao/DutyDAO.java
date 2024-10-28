package com.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.entity.Duty;

@Repository("dutyDAO") // Repository标签定义数据库连接的访问 Spring中直接
public interface DutyDAO {

	/**
	 * DutyDAO 接口 可以按名称直接调用duty.xml配置文件的SQL语句
	 */

	// 插入数据 调用entity包duty.xml里的insertDuty配置 返回值0(失败),1(成功)
	public int insertDuty(Duty duty);

	// 更新数据 调用entity包duty.xml里的updateDuty配置 返回值0(失败),1(成功)
	public int updateDuty(Duty duty);

	// 删除数据 调用entity包duty.xml里的deleteDuty配置 返回值0(失败),1(成功)
	public int deleteDuty(String dutyid);

	// 查询全部数据 调用entity包duty.xml里的getAllDuty配置 返回List类型的数据
	public List<Duty> getAllDuty();

	// 按照Duty类里面的值精确查询 调用entity包duty.xml里的getDutyByCond配置 返回List类型的数据
	public List<Duty> getDutyByCond(Duty duty);

	// 按照Duty类里面的值模糊查询 调用entity包duty.xml里的getDutyByLike配置 返回List类型的数据
	public List<Duty> getDutyByLike(Duty duty);

	// 按主键查询表返回单一的Duty实例 调用entity包duty.xml里的getDutyById配置
	public Duty getDutyById(String dutyid);

}
