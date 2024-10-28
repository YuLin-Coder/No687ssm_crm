package com.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.SoureDAO;
import com.entity.Soure;
import com.service.SoureService;

@Service("soureService")
public class SoureServiceImpl implements SoureService {
	@Autowired
	@Resource
	private SoureDAO soureDAO;

	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertSoure(Soure soure) {
		return this.soureDAO.insertSoure(soure);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateSoure(Soure soure) {
		return this.soureDAO.updateSoure(soure);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteSoure(String soureid) {
		return this.soureDAO.deleteSoure(soureid);
	}

	@Override // 继承接口的查询全部
	public List<Soure> getAllSoure() {
		return this.soureDAO.getAllSoure();
	}

	@Override // 继承接口的按条件精确查询
	public List<Soure> getSoureByCond(Soure soure) {
		return this.soureDAO.getSoureByCond(soure);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Soure> getSoureByLike(Soure soure) {
		return this.soureDAO.getSoureByLike(soure);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Soure getSoureById(String soureid) {
		return this.soureDAO.getSoureById(soureid);
	}

}
