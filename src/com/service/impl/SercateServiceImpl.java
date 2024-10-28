package com.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.SercateDAO;
import com.entity.Sercate;
import com.service.SercateService;

@Service("sercateService")
public class SercateServiceImpl implements SercateService {
	@Autowired
	@Resource
	private SercateDAO sercateDAO;

	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertSercate(Sercate sercate) {
		return this.sercateDAO.insertSercate(sercate);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateSercate(Sercate sercate) {
		return this.sercateDAO.updateSercate(sercate);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteSercate(String sercateid) {
		return this.sercateDAO.deleteSercate(sercateid);
	}

	@Override // 继承接口的查询全部
	public List<Sercate> getAllSercate() {
		return this.sercateDAO.getAllSercate();
	}

	@Override // 继承接口的按条件精确查询
	public List<Sercate> getSercateByCond(Sercate sercate) {
		return this.sercateDAO.getSercateByCond(sercate);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Sercate> getSercateByLike(Sercate sercate) {
		return this.sercateDAO.getSercateByLike(sercate);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Sercate getSercateById(String sercateid) {
		return this.sercateDAO.getSercateById(sercateid);
	}

}
