package com.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Serve;

@Service("serveService")
public interface ServeService {
	// 插入数据 调用serveDAO里的insertServe配置
	public int insertServe(Serve serve);

	// 更新数据 调用serveDAO里的updateServe配置
	public int updateServe(Serve serve);

	// 删除数据 调用serveDAO里的deleteServe配置
	public int deleteServe(String serveid);

	// 查询全部数据 调用serveDAO里的getAllServe配置
	public List<Serve> getAllServe();

	// 按照Serve类里面的字段名称精确查询 调用serveDAO里的getServeByCond配置
	public List<Serve> getServeByCond(Serve serve);

	// 按照Serve类里面的字段名称模糊查询 调用serveDAO里的getServeByLike配置
	public List<Serve> getServeByLike(Serve serve);

	// 按主键查询表返回单一的Serve实例 调用serveDAO里的getServeById配置
	public Serve getServeById(String serveid);

}
