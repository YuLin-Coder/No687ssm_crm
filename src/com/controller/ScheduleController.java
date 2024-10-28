package com.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Schedule;
import com.service.ScheduleService;
import com.util.PageHelper;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/schedule", produces = "text/plain;charset=utf-8")
public class ScheduleController extends BaseController {
	// 注入Service 由于标签的存在 所以不需要getter setter
	@Autowired
	@Resource
	private ScheduleService scheduleService;

	// 准备添加数据
	@RequestMapping("createSchedule.action")
	public String createSchedule() {
		return "addschedule";
	}

	// 添加数据
	@RequestMapping("addSchedule.action")
	public String addSchedule(Schedule schedule) {
		this.scheduleService.insertSchedule(schedule);
		return "redirect:/schedule/createSchedule.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteSchedule.action")
	public String deleteSchedule(String id) {
		this.scheduleService.deleteSchedule(id);
		return "redirect:/schedule/getAllSchedule.action";
	}

	// 批量删除数据
	@RequestMapping("deleteScheduleByIds.action")
	public String deleteScheduleByIds() {
		String[] ids = this.getRequest().getParameterValues("scheduleid");
		for (String scheduleid : ids) {
			this.scheduleService.deleteSchedule(scheduleid);
		}
		return "redirect:/schedule/getAllSchedule.action";
	}

	// 更新数据
	@RequestMapping("updateSchedule.action")
	public String updateSchedule(Schedule schedule) {
		this.scheduleService.updateSchedule(schedule);
		return "redirect:/schedule/getAllSchedule.action";
	}

	// 显示全部数据
	@RequestMapping("getAllSchedule.action")
	public String getAllSchedule(String number) {
		List<Schedule> scheduleList = this.scheduleService.getAllSchedule();
		PageHelper.getPage(scheduleList, "schedule", null, null, 10, number, this.getRequest(), null);
		return "listschedule";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryScheduleByCond.action")
	public String queryScheduleByCond(String cond, String name, String number) {
		Schedule schedule = new Schedule();
		if (cond != null) {
			if ("schedulename".equals(cond)) {
				schedule.setSchedulename(name);
			}
			if ("details".equals(cond)) {
				schedule.setDetails(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.scheduleService.getScheduleByLike(schedule), "schedule", nameList, valueList, 10,
				number, this.getRequest(), "query");
		name = null;
		cond = null;
		return "queryschedule";
	}

	// 按主键查询数据
	@RequestMapping("getScheduleById.action")
	public String getScheduleById(String id) {
		Schedule schedule = this.scheduleService.getScheduleById(id);
		this.getRequest().setAttribute("schedule", schedule);
		return "editschedule";
	}

	public ScheduleService getScheduleService() {
		return scheduleService;
	}

	public void setScheduleService(ScheduleService scheduleService) {
		this.scheduleService = scheduleService;
	}

}
