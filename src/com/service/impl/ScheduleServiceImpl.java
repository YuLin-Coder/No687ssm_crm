package com.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.ScheduleDAO;
import com.entity.Schedule;
import com.service.ScheduleService;

@Service("scheduleService")
public class ScheduleServiceImpl implements ScheduleService {
	@Autowired
	@Resource
	private ScheduleDAO scheduleDAO;

	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertSchedule(Schedule schedule) {
		return this.scheduleDAO.insertSchedule(schedule);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateSchedule(Schedule schedule) {
		return this.scheduleDAO.updateSchedule(schedule);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteSchedule(String scheduleid) {
		return this.scheduleDAO.deleteSchedule(scheduleid);
	}

	@Override // 继承接口的查询全部
	public List<Schedule> getAllSchedule() {
		return this.scheduleDAO.getAllSchedule();
	}

	@Override // 继承接口的按条件精确查询
	public List<Schedule> getScheduleByCond(Schedule schedule) {
		return this.scheduleDAO.getScheduleByCond(schedule);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Schedule> getScheduleByLike(Schedule schedule) {
		return this.scheduleDAO.getScheduleByLike(schedule);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Schedule getScheduleById(String scheduleid) {
		return this.scheduleDAO.getScheduleById(scheduleid);
	}

}
