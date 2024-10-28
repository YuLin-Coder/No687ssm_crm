package com.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.entity.Ranks;

@Repository("ranksDAO") // Repository标签定义数据库连接的访问 Spring中直接
public interface RanksDAO {

	/**
	 * RanksDAO 接口 可以按名称直接调用ranks.xml配置文件的SQL语句
	 */

	// 插入数据 调用entity包ranks.xml里的insertRanks配置 返回值0(失败),1(成功)
	public int insertRanks(Ranks ranks);

	// 更新数据 调用entity包ranks.xml里的updateRanks配置 返回值0(失败),1(成功)
	public int updateRanks(Ranks ranks);

	// 删除数据 调用entity包ranks.xml里的deleteRanks配置 返回值0(失败),1(成功)
	public int deleteRanks(String ranksid);

	// 查询全部数据 调用entity包ranks.xml里的getAllRanks配置 返回List类型的数据
	public List<Ranks> getAllRanks();

	// 按照Ranks类里面的值精确查询 调用entity包ranks.xml里的getRanksByCond配置 返回List类型的数据
	public List<Ranks> getRanksByCond(Ranks ranks);

	// 按照Ranks类里面的值模糊查询 调用entity包ranks.xml里的getRanksByLike配置 返回List类型的数据
	public List<Ranks> getRanksByLike(Ranks ranks);

	// 按主键查询表返回单一的Ranks实例 调用entity包ranks.xml里的getRanksById配置
	public Ranks getRanksById(String ranksid);

}
