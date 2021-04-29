package com.wfuhui.modules.help.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;

import com.wfuhui.common.utils.DateUtils;
import com.wfuhui.common.utils.Query;
import com.wfuhui.common.utils.R;
import com.wfuhui.modules.help.entity.OrderEntity;
import com.wfuhui.modules.help.service.OrderService;
import com.wfuhui.modules.lose.service.GoodsLoseService;
import com.wfuhui.modules.member.service.MemberService;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 订单
 */
@RestController
@RequestMapping("/order")
public class OrderController{
	@Autowired
	private OrderService orderService;
	@Autowired
	private MemberService memberService;
	@Autowired
	private GoodsLoseService goodsLoseService;
	
	@RequestMapping("/exportExcel")
	public void exportExcel(@RequestParam Map<String, Object> params, HttpServletResponse resp) throws IOException {
		List<OrderEntity> orderList = orderService.queryList(params);
		Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("订单列表", "订单"), OrderEntity.class, orderList);
		resp.setHeader("Content-disposition", "order.xls");  
		resp.setContentType("application/vnd.ms-excel");    
		resp.setHeader("Content-disposition", "attachment;filename=order.xls");    
		resp.setHeader("Pragma", "No-cache");  
		workbook.write(resp.getOutputStream());
	}
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<OrderEntity> orderList = orderService.queryList(query);
		int total = orderService.queryTotal(query);
		return R.ok().put("rows", orderList).put("total", total);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Integer id){

		OrderEntity order = orderService.queryObject(id);
		
		return R.ok().put("order", order);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody OrderEntity order){
		orderService.save(order);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody OrderEntity order){
		orderService.update(order);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Integer[] ids){
		orderService.deleteBatch(ids);
		
		return R.ok();
	}
	
	/**
	 * 发货
	 */
	@RequestMapping("/sendGoods/{orderId}")
	public R sendGoods(@PathVariable("orderId")Integer orderId, String courierNum) {
		OrderEntity order = new OrderEntity();
		order.setId(orderId);
		order.setOrderStatus(3);
		orderService.update(order);
		return R.ok();
	}
	
	@GetMapping("statistics")
	public R statistics() {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer userTotal = memberService.queryTotal(map);
		Integer goodsTotal = goodsLoseService.queryTotal(map);
		Integer orderTotal = orderService.queryTotal(map);

		// 近7天订单数
		List<Map<String, String>> orderCountList = orderService.queryOrderCount();

		Map<String, Object> result = new HashMap<String, Object>();
		result.put("userTotal", userTotal);
		result.put("orderTotal", orderTotal);
		result.put("goodsTotal", goodsTotal);
		if (orderCountList != null && orderCountList.size() > 0) {
			result.put("orderCountList", orderCountList);
		} else {
			// 补齐近7天数据，值为0
			Date now = new Date();
			orderCountList = new ArrayList<>();
			for (int i = -7; i < 0; i++) {
				Map<String, String> m = new HashMap<>();
				m.put("createTime", DateUtils.format(org.apache.commons.lang3.time.DateUtils.addDays(now, i)));
				m.put("count", "0");
				orderCountList.add(m);
			}
			result.put("orderCountList", orderCountList);
		}
		return R.ok().put("statistics", result);

	}
	
}
