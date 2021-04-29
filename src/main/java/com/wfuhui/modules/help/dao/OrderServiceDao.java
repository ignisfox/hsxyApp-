package com.wfuhui.modules.help.dao;

import org.apache.ibatis.annotations.Mapper;

import com.wfuhui.modules.help.entity.OrderServiceEntity;
import com.wfuhui.modules.sys.dao.BaseDao;

/**
 * 服务订单
 * 
 */
@Mapper
public interface OrderServiceDao extends BaseDao<OrderServiceEntity> {

	OrderServiceEntity queryByOrderId(Integer orderId);
	
}
