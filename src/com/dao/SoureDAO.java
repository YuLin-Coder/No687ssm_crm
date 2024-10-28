package com.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.entity.Soure;

@Repository("soureDAO") // Repository标签定义数据库连接的访问 Spring中直接
public interface SoureDAO {

	/**
	 * SoureDAO 接口 可以按名称直接调用soure.xml配置文件的SQL语句
	 */

	// 插入数据 调用entity包soure.xml里的insertSoure配置 返回值0(失败),1(成功)
	public int insertSoure(Soure soure);

	// 更新数据 调用entity包soure.xml里的updateSoure配置 返回值0(失败),1(成功)
	public int updateSoure(Soure soure);

	// 删除数据 调用entity包soure.xml里的deleteSoure配置 返回值0(失败),1(成功)
	public int deleteSoure(String soureid);

	// 查询全部数据 调用entity包soure.xml里的getAllSoure配置 返回List类型的数据
	public List<Soure> getAllSoure();

	// 按照Soure类里面的值精确查询 调用entity包soure.xml里的getSoureByCond配置 返回List类型的数据
	public List<Soure> getSoureByCond(Soure soure);

	// 按照Soure类里面的值模糊查询 调用entity包soure.xml里的getSoureByLike配置 返回List类型的数据
	public List<Soure> getSoureByLike(Soure soure);

	// 按主键查询表返回单一的Soure实例 调用entity包soure.xml里的getSoureById配置
	public Soure getSoureById(String soureid);

}
