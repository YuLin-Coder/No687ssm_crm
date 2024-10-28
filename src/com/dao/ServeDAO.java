package com.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.entity.Serve;

@Repository("serveDAO") // Repository标签定义数据库连接的访问 Spring中直接
public interface ServeDAO {

	/**
	 * ServeDAO 接口 可以按名称直接调用serve.xml配置文件的SQL语句
	 */

	// 插入数据 调用entity包serve.xml里的insertServe配置 返回值0(失败),1(成功)
	public int insertServe(Serve serve);

	// 更新数据 调用entity包serve.xml里的updateServe配置 返回值0(失败),1(成功)
	public int updateServe(Serve serve);

	// 删除数据 调用entity包serve.xml里的deleteServe配置 返回值0(失败),1(成功)
	public int deleteServe(String serveid);

	// 查询全部数据 调用entity包serve.xml里的getAllServe配置 返回List类型的数据
	public List<Serve> getAllServe();

	// 按照Serve类里面的值精确查询 调用entity包serve.xml里的getServeByCond配置 返回List类型的数据
	public List<Serve> getServeByCond(Serve serve);

	// 按照Serve类里面的值模糊查询 调用entity包serve.xml里的getServeByLike配置 返回List类型的数据
	public List<Serve> getServeByLike(Serve serve);

	// 按主键查询表返回单一的Serve实例 调用entity包serve.xml里的getServeById配置
	public Serve getServeById(String serveid);

}
