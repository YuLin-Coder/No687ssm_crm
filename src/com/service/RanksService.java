package com.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Ranks;

@Service("ranksService")
public interface RanksService {
	// 插入数据 调用ranksDAO里的insertRanks配置
	public int insertRanks(Ranks ranks);

	// 更新数据 调用ranksDAO里的updateRanks配置
	public int updateRanks(Ranks ranks);

	// 删除数据 调用ranksDAO里的deleteRanks配置
	public int deleteRanks(String ranksid);

	// 查询全部数据 调用ranksDAO里的getAllRanks配置
	public List<Ranks> getAllRanks();

	// 按照Ranks类里面的字段名称精确查询 调用ranksDAO里的getRanksByCond配置
	public List<Ranks> getRanksByCond(Ranks ranks);

	// 按照Ranks类里面的字段名称模糊查询 调用ranksDAO里的getRanksByLike配置
	public List<Ranks> getRanksByLike(Ranks ranks);

	// 按主键查询表返回单一的Ranks实例 调用ranksDAO里的getRanksById配置
	public Ranks getRanksById(String ranksid);

}
