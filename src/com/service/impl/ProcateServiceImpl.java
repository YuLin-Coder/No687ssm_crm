package com.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.ProcateDAO;
import com.entity.Procate;
import com.service.ProcateService;

@Service("procateService")
public class ProcateServiceImpl implements ProcateService {
	@Autowired
	@Resource
	private ProcateDAO procateDAO;

	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertProcate(Procate procate) {
		return this.procateDAO.insertProcate(procate);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateProcate(Procate procate) {
		return this.procateDAO.updateProcate(procate);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteProcate(String procateid) {
		return this.procateDAO.deleteProcate(procateid);
	}

	@Override // 继承接口的查询全部
	public List<Procate> getAllProcate() {
		return this.procateDAO.getAllProcate();
	}

	@Override // 继承接口的按条件精确查询
	public List<Procate> getProcateByCond(Procate procate) {
		return this.procateDAO.getProcateByCond(procate);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Procate> getProcateByLike(Procate procate) {
		return this.procateDAO.getProcateByLike(procate);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Procate getProcateById(String procateid) {
		return this.procateDAO.getProcateById(procateid);
	}

}
