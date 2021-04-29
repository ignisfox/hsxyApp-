package com.wfuhui.modules.help.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wfuhui.modules.help.dao.OrderServiceDao;
import com.wfuhui.modules.help.entity.OrderServiceEntity;
import com.wfuhui.modules.help.service.OrderServiceService;



@Service("orderServiceService")
public class OrderServiceServiceImpl implements OrderServiceService {
	@Autowired
	private OrderServiceDao orderServiceDao;
	
	@Override
	public OrderServiceEntity queryObject(Integer id){
		return orderServiceDao.queryObject(id);
	}
	
	@Override
	public List<OrderServiceEntity> queryList(Map<String, Object> map){
		return orderServiceDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return orderServiceDao.queryTotal(map);
	}
	
	@Override
	public void save(OrderServiceEntity orderService){
		orderServiceDao.save(orderService);
	}
	
	@Override
	public void update(OrderServiceEntity orderService){
		orderServiceDao.update(orderService);
	}
	
	@Override
	public void delete(Integer id){
		orderServiceDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		orderServiceDao.deleteBatch(ids);
	}
	
}
