package com.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Procate;

@Service("procateService")
public interface ProcateService {
	// 插入数据 调用procateDAO里的insertProcate配置
	public int insertProcate(Procate procate);

	// 更新数据 调用procateDAO里的updateProcate配置
	public int updateProcate(Procate procate);

	// 删除数据 调用procateDAO里的deleteProcate配置
	public int deleteProcate(String procateid);

	// 查询全部数据 调用procateDAO里的getAllProcate配置
	public List<Procate> getAllProcate();

	// 按照Procate类里面的字段名称精确查询 调用procateDAO里的getProcateByCond配置
	public List<Procate> getProcateByCond(Procate procate);

	// 按照Procate类里面的字段名称模糊查询 调用procateDAO里的getProcateByLike配置
	public List<Procate> getProcateByLike(Procate procate);

	// 按主键查询表返回单一的Procate实例 调用procateDAO里的getProcateById配置
	public Procate getProcateById(String procateid);

}
