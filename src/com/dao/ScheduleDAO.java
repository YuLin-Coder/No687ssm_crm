package com.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.entity.Schedule;

@Repository("scheduleDAO") // Repository标签定义数据库连接的访问 Spring中直接
public interface ScheduleDAO {

	/**
	 * ScheduleDAO 接口 可以按名称直接调用schedule.xml配置文件的SQL语句
	 */

	// 插入数据 调用entity包schedule.xml里的insertSchedule配置 返回值0(失败),1(成功)
	public int insertSchedule(Schedule schedule);

	// 更新数据 调用entity包schedule.xml里的updateSchedule配置 返回值0(失败),1(成功)
	public int updateSchedule(Schedule schedule);

	// 删除数据 调用entity包schedule.xml里的deleteSchedule配置 返回值0(失败),1(成功)
	public int deleteSchedule(String scheduleid);

	// 查询全部数据 调用entity包schedule.xml里的getAllSchedule配置 返回List类型的数据
	public List<Schedule> getAllSchedule();

	// 按照Schedule类里面的值精确查询 调用entity包schedule.xml里的getScheduleByCond配置
	// 返回List类型的数据
	public List<Schedule> getScheduleByCond(Schedule schedule);

	// 按照Schedule类里面的值模糊查询 调用entity包schedule.xml里的getScheduleByLike配置
	// 返回List类型的数据
	public List<Schedule> getScheduleByLike(Schedule schedule);

	// 按主键查询表返回单一的Schedule实例 调用entity包schedule.xml里的getScheduleById配置
	public Schedule getScheduleById(String scheduleid);

}
