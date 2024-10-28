package com.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.ServeDAO;
import com.entity.Serve;
import com.service.ServeService;

@Service("serveService")
public class ServeServiceImpl implements ServeService {
	@Autowired
	@Resource
	private ServeDAO serveDAO;

	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertServe(Serve serve) {
		return this.serveDAO.insertServe(serve);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateServe(Serve serve) {
		return this.serveDAO.updateServe(serve);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteServe(String serveid) {
		return this.serveDAO.deleteServe(serveid);
	}

	@Override // 继承接口的查询全部
	public List<Serve> getAllServe() {
		return this.serveDAO.getAllServe();
	}

	@Override // 继承接口的按条件精确查询
	public List<Serve> getServeByCond(Serve serve) {
		return this.serveDAO.getServeByCond(serve);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Serve> getServeByLike(Serve serve) {
		return this.serveDAO.getServeByLike(serve);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Serve getServeById(String serveid) {
		return this.serveDAO.getServeById(serveid);
	}

}
