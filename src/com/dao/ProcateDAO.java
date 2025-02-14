package com.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.entity.Procate;

@Repository("procateDAO") // Repository标签定义数据库连接的访问 Spring中直接
public interface ProcateDAO {

	/**
	 * ProcateDAO 接口 可以按名称直接调用procate.xml配置文件的SQL语句
	 */

	// 插入数据 调用entity包procate.xml里的insertProcate配置 返回值0(失败),1(成功)
	public int insertProcate(Procate procate);

	// 更新数据 调用entity包procate.xml里的updateProcate配置 返回值0(失败),1(成功)
	public int updateProcate(Procate procate);

	// 删除数据 调用entity包procate.xml里的deleteProcate配置 返回值0(失败),1(成功)
	public int deleteProcate(String procateid);

	// 查询全部数据 调用entity包procate.xml里的getAllProcate配置 返回List类型的数据
	public List<Procate> getAllProcate();

	// 按照Procate类里面的值精确查询 调用entity包procate.xml里的getProcateByCond配置 返回List类型的数据
	public List<Procate> getProcateByCond(Procate procate);

	// 按照Procate类里面的值模糊查询 调用entity包procate.xml里的getProcateByLike配置 返回List类型的数据
	public List<Procate> getProcateByLike(Procate procate);

	// 按主键查询表返回单一的Procate实例 调用entity包procate.xml里的getProcateById配置
	public Procate getProcateById(String procateid);

}
