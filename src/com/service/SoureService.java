package com.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Soure;

@Service("soureService")
public interface SoureService {
	// 插入数据 调用soureDAO里的insertSoure配置
	public int insertSoure(Soure soure);

	// 更新数据 调用soureDAO里的updateSoure配置
	public int updateSoure(Soure soure);

	// 删除数据 调用soureDAO里的deleteSoure配置
	public int deleteSoure(String soureid);

	// 查询全部数据 调用soureDAO里的getAllSoure配置
	public List<Soure> getAllSoure();

	// 按照Soure类里面的字段名称精确查询 调用soureDAO里的getSoureByCond配置
	public List<Soure> getSoureByCond(Soure soure);

	// 按照Soure类里面的字段名称模糊查询 调用soureDAO里的getSoureByLike配置
	public List<Soure> getSoureByLike(Soure soure);

	// 按主键查询表返回单一的Soure实例 调用soureDAO里的getSoureById配置
	public Soure getSoureById(String soureid);

}
