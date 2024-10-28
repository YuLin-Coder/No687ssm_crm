package com.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Schedule;

@Service("scheduleService")
public interface ScheduleService {
	// 插入数据 调用scheduleDAO里的insertSchedule配置
	public int insertSchedule(Schedule schedule);

	// 更新数据 调用scheduleDAO里的updateSchedule配置
	public int updateSchedule(Schedule schedule);

	// 删除数据 调用scheduleDAO里的deleteSchedule配置
	public int deleteSchedule(String scheduleid);

	// 查询全部数据 调用scheduleDAO里的getAllSchedule配置
	public List<Schedule> getAllSchedule();

	// 按照Schedule类里面的字段名称精确查询 调用scheduleDAO里的getScheduleByCond配置
	public List<Schedule> getScheduleByCond(Schedule schedule);

	// 按照Schedule类里面的字段名称模糊查询 调用scheduleDAO里的getScheduleByLike配置
	public List<Schedule> getScheduleByLike(Schedule schedule);

	// 按主键查询表返回单一的Schedule实例 调用scheduleDAO里的getScheduleById配置
	public Schedule getScheduleById(String scheduleid);

}
