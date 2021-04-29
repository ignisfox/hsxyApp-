package com.wfuhui.modules.lose.service;

import java.util.List;
import java.util.Map;

import com.wfuhui.modules.lose.entity.GoodsLoseEntity;

/**
 * 失物招领
 * 
 */
public interface GoodsLoseService {
	
	GoodsLoseEntity queryObject(Integer id);
	
	List<GoodsLoseEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(GoodsLoseEntity goodsLose);
	
	void update(GoodsLoseEntity goodsLose);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
