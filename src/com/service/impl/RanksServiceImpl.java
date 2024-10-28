package com.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.RanksDAO;
import com.entity.Ranks;
import com.service.RanksService;

@Service("ranksService")
public class RanksServiceImpl implements RanksService {
	@Autowired
	@Resource
	private RanksDAO ranksDAO;

	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertRanks(Ranks ranks) {
		return this.ranksDAO.insertRanks(ranks);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateRanks(Ranks ranks) {
		return this.ranksDAO.updateRanks(ranks);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteRanks(String ranksid) {
		return this.ranksDAO.deleteRanks(ranksid);
	}

	@Override // 继承接口的查询全部
	public List<Ranks> getAllRanks() {
		return this.ranksDAO.getAllRanks();
	}

	@Override // 继承接口的按条件精确查询
	public List<Ranks> getRanksByCond(Ranks ranks) {
		return this.ranksDAO.getRanksByCond(ranks);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Ranks> getRanksByLike(Ranks ranks) {
		return this.ranksDAO.getRanksByLike(ranks);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Ranks getRanksById(String ranksid) {
		return this.ranksDAO.getRanksById(ranksid);
	}

}
