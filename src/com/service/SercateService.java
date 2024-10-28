package com.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Sercate;

@Service("sercateService")
public interface SercateService {
	// 插入数据 调用sercateDAO里的insertSercate配置
	public int insertSercate(Sercate sercate);

	// 更新数据 调用sercateDAO里的updateSercate配置
	public int updateSercate(Sercate sercate);

	// 删除数据 调用sercateDAO里的deleteSercate配置
	public int deleteSercate(String sercateid);

	// 查询全部数据 调用sercateDAO里的getAllSercate配置
	public List<Sercate> getAllSercate();

	// 按照Sercate类里面的字段名称精确查询 调用sercateDAO里的getSercateByCond配置
	public List<Sercate> getSercateByCond(Sercate sercate);

	// 按照Sercate类里面的字段名称模糊查询 调用sercateDAO里的getSercateByLike配置
	public List<Sercate> getSercateByLike(Sercate sercate);

	// 按主键查询表返回单一的Sercate实例 调用sercateDAO里的getSercateById配置
	public Sercate getSercateById(String sercateid);

}
