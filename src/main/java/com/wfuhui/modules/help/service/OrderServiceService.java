package com.wfuhui.modules.help.service;

import java.util.List;
import java.util.Map;

import com.wfuhui.modules.help.entity.OrderServiceEntity;

/**
 * 服务订单
 * 
 * @author lizhengle
 * @email 2803180149@qq.com
 */
public interface OrderServiceService {
	
	OrderServiceEntity queryObject(Integer id);
	
	List<OrderServiceEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(OrderServiceEntity orderService);
	
	void update(OrderServiceEntity orderService);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
