package com.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Duty;

@Service("dutyService")
public interface DutyService {
	// 插入数据 调用dutyDAO里的insertDuty配置
	public int insertDuty(Duty duty);

	// 更新数据 调用dutyDAO里的updateDuty配置
	public int updateDuty(Duty duty);

	// 删除数据 调用dutyDAO里的deleteDuty配置
	public int deleteDuty(String dutyid);

	// 查询全部数据 调用dutyDAO里的getAllDuty配置
	public List<Duty> getAllDuty();

	// 按照Duty类里面的字段名称精确查询 调用dutyDAO里的getDutyByCond配置
	public List<Duty> getDutyByCond(Duty duty);

	// 按照Duty类里面的字段名称模糊查询 调用dutyDAO里的getDutyByLike配置
	public List<Duty> getDutyByLike(Duty duty);

	// 按主键查询表返回单一的Duty实例 调用dutyDAO里的getDutyById配置
	public Duty getDutyById(String dutyid);

}
