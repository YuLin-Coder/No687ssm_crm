package com.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Payway;

@Service("paywayService")
public interface PaywayService {
	// 插入数据 调用paywayDAO里的insertPayway配置
	public int insertPayway(Payway payway);

	// 更新数据 调用paywayDAO里的updatePayway配置
	public int updatePayway(Payway payway);

	// 删除数据 调用paywayDAO里的deletePayway配置
	public int deletePayway(String paywayid);

	// 查询全部数据 调用paywayDAO里的getAllPayway配置
	public List<Payway> getAllPayway();

	// 按照Payway类里面的字段名称精确查询 调用paywayDAO里的getPaywayByCond配置
	public List<Payway> getPaywayByCond(Payway payway);

	// 按照Payway类里面的字段名称模糊查询 调用paywayDAO里的getPaywayByLike配置
	public List<Payway> getPaywayByLike(Payway payway);

	// 按主键查询表返回单一的Payway实例 调用paywayDAO里的getPaywayById配置
	public Payway getPaywayById(String paywayid);

}
