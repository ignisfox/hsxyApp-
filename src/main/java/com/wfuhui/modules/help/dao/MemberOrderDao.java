package com.wfuhui.modules.help.dao;

import org.apache.ibatis.annotations.Mapper;

import com.wfuhui.modules.help.entity.MemberOrderEntity;
import com.wfuhui.modules.sys.dao.BaseDao;

/**
 * 分销订单
 * 
 */
@Mapper
public interface MemberOrderDao extends BaseDao<MemberOrderEntity> {

	MemberOrderEntity queryByOrderId(Integer orderId);
	
}
