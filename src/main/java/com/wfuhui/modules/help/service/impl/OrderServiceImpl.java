package com.wfuhui.modules.help.service.impl;

import java.util.List;
import java.util.Map;

import com.wfuhui.modules.help.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wfuhui.common.utils.OrderNumberUtil;
import com.wfuhui.common.utils.Query;
import com.wfuhui.modules.help.dao.MemberOrderDao;
import com.wfuhui.modules.help.dao.OrderDao;
import com.wfuhui.modules.help.dao.OrderServiceDao;
import com.wfuhui.modules.help.service.OrderService;



@Service("orderService")
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private OrderServiceDao orderServiceDao;
	@Autowired
	private MemberOrderDao memberOrderDao;
	
	@Override
	public OrderEntity queryObject(Integer orderId){
		OrderEntity order = orderDao.queryObject(orderId);
		OrderServiceEntity orderService = orderServiceDao.queryByOrderId(orderId);
		order.setOrderService(orderService);
		return order;
	}
	
	@Override
	public List<OrderEntity> queryList(Map<String, Object> map){
		List<OrderEntity> orderList = orderDao.queryList(map);
		return orderList;
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return orderDao.queryTotal(map);
	}
	
	@Override
	public void save(OrderEntity order){
		orderDao.save(order);
	}
	
	@Override
	public void update(OrderEntity order){
		orderDao.update(order);
	}
	
	@Override
	public void delete(Integer id){
		orderDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		orderDao.deleteBatch(ids);
	}

	@Override
	@Transactional
	public void createOrder(OrderEntity order) {
		order.setOrderNumber(OrderNumberUtil.getOrderNumber());
		orderDao.save(order);
		OrderServiceEntity orderService = order.getOrderService();
		if(orderService != null) { //服务订单
			orderService.setOrderId(order.getId());
			orderServiceDao.save(orderService);
		}
	}

	@Override
	public void updateByOrderNum(OrderEntity order) {
		orderDao.updateByOrderNum(order);
	}

	@Override
	public List<Map<String, String>> queryOrderCount() {
		return orderDao.queryOrderCount();
	}

	@Override
	@Transactional
	public int grabOrder(Integer orderId, Integer userId) {
		MemberOrderEntity memberOrder = memberOrderDao.queryByOrderId(orderId);
    	if(memberOrder != null){
    		return 1;
    	}else{
    		memberOrder = new MemberOrderEntity();
    		memberOrder.setOrderId(orderId);
    		memberOrder.setMemberId(userId);
    		memberOrderDao.save(memberOrder);
    		OrderEntity order = new OrderEntity();
    		order.setId(orderId);
    		order.setOrderStatus(3);
    		orderDao.update(order);
    		return 0;
    	}
	}

	@Override
	public List<OrderEntity> queryCourierOrder(Query query) {
		return orderDao.queryCourierOrder(query);
	}

	@Override
	public List<DormitoryBuildingEntity> queryAllDormitorys() {

		return orderDao.queryAllDormitorys();
	}

	@Override
	public List<PickupAddressEntity> queryAllPickupAddress() {
		return orderDao.queryAllPickupAddress();
	}
}
