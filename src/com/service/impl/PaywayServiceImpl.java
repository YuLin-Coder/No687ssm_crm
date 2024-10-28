package com.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.PaywayDAO;
import com.entity.Payway;
import com.service.PaywayService;

@Service("paywayService")
public class PaywayServiceImpl implements PaywayService {
	@Autowired
	@Resource
	private PaywayDAO paywayDAO;

	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertPayway(Payway payway) {
		return this.paywayDAO.insertPayway(payway);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updatePayway(Payway payway) {
		return this.paywayDAO.updatePayway(payway);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deletePayway(String paywayid) {
		return this.paywayDAO.deletePayway(paywayid);
	}

	@Override // 继承接口的查询全部
	public List<Payway> getAllPayway() {
		return this.paywayDAO.getAllPayway();
	}

	@Override // 继承接口的按条件精确查询
	public List<Payway> getPaywayByCond(Payway payway) {
		return this.paywayDAO.getPaywayByCond(payway);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Payway> getPaywayByLike(Payway payway) {
		return this.paywayDAO.getPaywayByLike(payway);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Payway getPaywayById(String paywayid) {
		return this.paywayDAO.getPaywayById(paywayid);
	}

}
