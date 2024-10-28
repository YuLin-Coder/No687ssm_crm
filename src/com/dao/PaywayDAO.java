package com.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.entity.Payway;

@Repository("paywayDAO") // Repository标签定义数据库连接的访问 Spring中直接
public interface PaywayDAO {

	/**
	 * PaywayDAO 接口 可以按名称直接调用payway.xml配置文件的SQL语句
	 */

	// 插入数据 调用entity包payway.xml里的insertPayway配置 返回值0(失败),1(成功)
	public int insertPayway(Payway payway);

	// 更新数据 调用entity包payway.xml里的updatePayway配置 返回值0(失败),1(成功)
	public int updatePayway(Payway payway);

	// 删除数据 调用entity包payway.xml里的deletePayway配置 返回值0(失败),1(成功)
	public int deletePayway(String paywayid);

	// 查询全部数据 调用entity包payway.xml里的getAllPayway配置 返回List类型的数据
	public List<Payway> getAllPayway();

	// 按照Payway类里面的值精确查询 调用entity包payway.xml里的getPaywayByCond配置 返回List类型的数据
	public List<Payway> getPaywayByCond(Payway payway);

	// 按照Payway类里面的值模糊查询 调用entity包payway.xml里的getPaywayByLike配置 返回List类型的数据
	public List<Payway> getPaywayByLike(Payway payway);

	// 按主键查询表返回单一的Payway实例 调用entity包payway.xml里的getPaywayById配置
	public Payway getPaywayById(String paywayid);

}
