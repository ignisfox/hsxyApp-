package com.wfuhui.modules.help.api;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wfuhui.modules.help.entity.DormitoryBuildingEntity;
import com.wfuhui.modules.help.entity.PickupAddressEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wfuhui.common.annotation.AuthIgnore;
import com.wfuhui.common.annotation.Login;
import com.wfuhui.common.utils.Query;
import com.wfuhui.common.utils.R;
import com.wfuhui.modules.help.entity.OrderEntity;
import com.wfuhui.modules.help.service.OrderService;

/**
 * 订单
 *
 */
@RestController
@RequestMapping("/api/order")
public class ApiOrderController {
	
	@Autowired
	private OrderService orderService;

	

	@Login
	@PostMapping("createOrder")
	public R createOrder(@RequestAttribute("userId") Integer userId, @RequestBody OrderEntity orderEntity){
		orderEntity.setMemberId(userId);
		orderEntity.setCreateTime(new Date());
		orderEntity.setOrderStatus(2);
		orderService.createOrder(orderEntity);
		return R.ok();
	}

	/**
	 * 获取收货地址的宿舍楼信息
	 * @return
	 */

	@AuthIgnore
	@GetMapping("dormitory")
	public R getDormitory(){
		List<DormitoryBuildingEntity> dormitoryBuildingEntities=orderService.queryAllDormitorys();
		return R.ok().put("dormitoryBuildingEntities",dormitoryBuildingEntities);
	}

	/**
	 *
	 * @return
	 */

	@AuthIgnore
	@GetMapping("address")
	public R getPickupAddress(){
		List<PickupAddressEntity> pickupAddressEntities=orderService.queryAllPickupAddress();
		return R.ok().put("pickupAddressEntities",pickupAddressEntities);
	}


	@Login
	@GetMapping("myOrderservice")
    public R myOrderservice(@RequestAttribute("userId") Integer userId, @RequestParam Map<String, Object> params){
		params.put("memberId", userId);//2
    	Query query = new Query(params);
    	List<OrderEntity> orderList = orderService.queryList(query);
        return R.ok().put("orderList", orderList);
    }



	@AuthIgnore
    @GetMapping("orderservice")
    public R orderservice(@RequestParam Map<String, Object> params){
    	Query query = new Query(params);
    	List<OrderEntity> orderList = orderService.queryList(query);
        return R.ok().put("orderList", orderList);
    }
	
	@Login
    @GetMapping("getOrderList")
    public R getOrderList(@RequestAttribute("userId") Integer userId, @RequestParam Map<String, Object> params){
    	params.put("memberId", userId);
    	List<OrderEntity> orderList = orderService.queryList(params);
        return R.ok().put("orderList", orderList);
    }
    

	@Login
    @GetMapping("orderDetail")
    public R getOrderDetail(Integer id) {
    	OrderEntity order = orderService.queryObject(id);
    	return R.ok().put("order", order);
    }
	
	@AuthIgnore
    @GetMapping("orderServiceDetail")
    public R orderServiceDetail(Integer id) {
    	OrderEntity order = orderService.queryObject(id);
    	return R.ok().put("order", order);
    }
    
    @Login
    @GetMapping("cancelOrder")
    public R cancelOrder(Integer id) {
    	OrderEntity order = new OrderEntity();
    	order.setOrderStatus(0);
    	order.setId(id);
    	orderService.update(order);
    	return R.ok();
    }
    
    @Login
    @GetMapping("confirmOrder")
    public R confirmOrder(Integer orderId) {
    	OrderEntity order = new OrderEntity();
    	order.setOrderStatus(4);
    	order.setId(orderId);
    	orderService.update(order);
    	return R.ok();
    }
    
    @Login
    @GetMapping("confirmOrderService")
    public R confirmOrderService(Integer orderId) {
    	OrderEntity order = new OrderEntity();
    	order.setOrderStatus(4);
    	order.setId(orderId);
    	orderService.update(order);
    	return R.ok();
    }
    
    @Login
    @GetMapping("courierOrder")
    public R courierOrder(@RequestParam Map<String, Object> params, @RequestAttribute("userId") Integer userId){
    	params.put("courier", userId);
    	Query query = new Query(params);
    	List<OrderEntity> orderList = orderService.queryCourierOrder(query);
        return R.ok().put("orderList", orderList);
    }
    
    @Login
    @GetMapping("grabOrder")
    public R grabOrder(Integer orderId, @RequestAttribute("userId") Integer userId){
    	
    	int result = orderService.grabOrder(orderId, userId);
    	if(result != 0){
    		return R.error("抢单失败，已被抢");
    	}else{
    		return R.ok("抢单成功");
    	}
    }
    
    @Login
    @GetMapping("statistics")
    public R statistics(@RequestAttribute("userId") Integer userId, Integer storeId) {
    	
    	Map<String, Object> params = new HashMap<String, Object>();
    	params.put("orderStatus", 1);
    	params.put("storeId", storeId);
    	
    	Integer countNoPay = orderService.queryTotal(params);
    	params.put("orderStatus", 2);
    	Integer countNoTransfer = orderService.queryTotal(params);
    	params.put("orderStatus", 3);
    	Integer countNoConfirm = orderService.queryTotal(params);
    	params.put("orderStatus", 4);
    	Integer countSuccess = orderService.queryTotal(params);
    	
    	Map<String, Object> result = new HashMap<String, Object>();
    	result.put("count_no_pay", countNoPay);
    	result.put("count_no_transfer", countNoTransfer);
    	result.put("count_no_confirm", countNoConfirm);
    	result.put("count_success", countSuccess);
    	return R.ok().put("statistics", result);
    }
    
}
