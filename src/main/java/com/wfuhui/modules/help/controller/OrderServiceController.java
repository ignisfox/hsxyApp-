package com.wfuhui.modules.help.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wfuhui.common.utils.Query;
import com.wfuhui.common.utils.R;
import com.wfuhui.modules.help.entity.OrderServiceEntity;
import com.wfuhui.modules.help.service.OrderServiceService;

/**
 * 服务订单
 */
@RestController
@RequestMapping("orderservice")
public class OrderServiceController {
	@Autowired
	private OrderServiceService orderServiceService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<OrderServiceEntity> orderServiceList = orderServiceService.queryList(query);
		int total = orderServiceService.queryTotal(query);
		
		return R.ok().put("rows", orderServiceList).put("total", total);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Integer id){
		OrderServiceEntity orderService = orderServiceService.queryObject(id);
		
		return R.ok().put("orderService", orderService);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody OrderServiceEntity orderService){
		orderServiceService.save(orderService);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody OrderServiceEntity orderService){
		orderServiceService.update(orderService);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Integer[] ids){
		orderServiceService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
