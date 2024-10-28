package com.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.entity.Sercate;

@Repository("sercateDAO") // Repository标签定义数据库连接的访问 Spring中直接
public interface SercateDAO {

	/**
	 * SercateDAO 接口 可以按名称直接调用sercate.xml配置文件的SQL语句
	 */

	// 插入数据 调用entity包sercate.xml里的insertSercate配置 返回值0(失败),1(成功)
	public int insertSercate(Sercate sercate);

	// 更新数据 调用entity包sercate.xml里的updateSercate配置 返回值0(失败),1(成功)
	public int updateSercate(Sercate sercate);

	// 删除数据 调用entity包sercate.xml里的deleteSercate配置 返回值0(失败),1(成功)
	public int deleteSercate(String sercateid);

	// 查询全部数据 调用entity包sercate.xml里的getAllSercate配置 返回List类型的数据
	public List<Sercate> getAllSercate();

	// 按照Sercate类里面的值精确查询 调用entity包sercate.xml里的getSercateByCond配置 返回List类型的数据
	public List<Sercate> getSercateByCond(Sercate sercate);

	// 按照Sercate类里面的值模糊查询 调用entity包sercate.xml里的getSercateByLike配置 返回List类型的数据
	public List<Sercate> getSercateByLike(Sercate sercate);

	// 按主键查询表返回单一的Sercate实例 调用entity包sercate.xml里的getSercateById配置
	public Sercate getSercateById(String sercateid);

}
