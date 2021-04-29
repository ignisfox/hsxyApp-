package com.wfuhui.modules.help.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.wfuhui.common.utils.Query;
import com.wfuhui.modules.help.entity.OrderEntity;
import com.wfuhui.modules.sys.dao.BaseDao;

/**
 * 订单
 * 
 */
@Mapper
public interface OrderDao extends BaseDao<OrderEntity> {

	void updateByOrderNum(OrderEntity order);

	List<Map<String, String>> queryOrderCount();

	List<OrderEntity> queryCourierOrder(Query query);
	
}
