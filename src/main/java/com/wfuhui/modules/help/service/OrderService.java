package com.wfuhui.modules.help.service;

import java.util.List;
import java.util.Map;

import com.wfuhui.common.utils.Query;
import com.wfuhui.modules.help.entity.OrderEntity;

/**
 * 订单
 * 
 */
public interface OrderService {
	
	OrderEntity queryObject(Integer orderId);
	
	List<OrderEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(OrderEntity order);
	
	void update(OrderEntity order);
	
	void delete(Integer orderId);
	
	void deleteBatch(Integer[] ids);

	void createOrder(OrderEntity orderEntity);

	void updateByOrderNum(OrderEntity order);

	List<Map<String, String>> queryOrderCount();

	int grabOrder(Integer orderId, Integer userId);

	List<OrderEntity> queryCourierOrder(Query query);
}
