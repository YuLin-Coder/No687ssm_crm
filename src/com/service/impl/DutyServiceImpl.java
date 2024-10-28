package com.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.DutyDAO;
import com.entity.Duty;
import com.service.DutyService;

@Service("dutyService")
public class DutyServiceImpl implements DutyService {
	@Autowired
	@Resource
	private DutyDAO dutyDAO;

	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertDuty(Duty duty) {
		return this.dutyDAO.insertDuty(duty);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateDuty(Duty duty) {
		return this.dutyDAO.updateDuty(duty);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteDuty(String dutyid) {
		return this.dutyDAO.deleteDuty(dutyid);
	}

	@Override // 继承接口的查询全部
	public List<Duty> getAllDuty() {
		return this.dutyDAO.getAllDuty();
	}

	@Override // 继承接口的按条件精确查询
	public List<Duty> getDutyByCond(Duty duty) {
		return this.dutyDAO.getDutyByCond(duty);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Duty> getDutyByLike(Duty duty) {
		return this.dutyDAO.getDutyByLike(duty);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Duty getDutyById(String dutyid) {
		return this.dutyDAO.getDutyById(dutyid);
	}

}
