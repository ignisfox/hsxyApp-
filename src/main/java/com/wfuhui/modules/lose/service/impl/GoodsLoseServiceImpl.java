package com.wfuhui.modules.lose.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wfuhui.modules.lose.dao.GoodsLoseDao;
import com.wfuhui.modules.lose.entity.GoodsLoseEntity;
import com.wfuhui.modules.lose.service.GoodsLoseService;



@Service("goodsLoseService")
public class GoodsLoseServiceImpl implements GoodsLoseService {
	@Autowired
	private GoodsLoseDao goodsLoseDao;
	
	@Override
	public GoodsLoseEntity queryObject(Integer id){
		return goodsLoseDao.queryObject(id);
	}
	
	@Override
	public List<GoodsLoseEntity> queryList(Map<String, Object> map){
		return goodsLoseDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return goodsLoseDao.queryTotal(map);
	}
	
	@Override
	public void save(GoodsLoseEntity goodsLose){
		goodsLoseDao.save(goodsLose);
	}
	
	@Override
	public void update(GoodsLoseEntity goodsLose){
		goodsLoseDao.update(goodsLose);
	}
	
	@Override
	public void delete(Integer id){
		goodsLoseDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		goodsLoseDao.deleteBatch(ids);
	}
	
}
