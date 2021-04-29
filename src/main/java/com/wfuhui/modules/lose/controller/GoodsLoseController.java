package com.wfuhui.modules.lose.controller;

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
import com.wfuhui.modules.lose.entity.GoodsLoseEntity;
import com.wfuhui.modules.lose.service.GoodsLoseService;


/**
 * 失物招领
 * 
 */
@RestController
@RequestMapping("goodslose")
public class GoodsLoseController {
	@Autowired
	private GoodsLoseService goodsLoseService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<GoodsLoseEntity> goodsLoseList = goodsLoseService.queryList(query);
		int total = goodsLoseService.queryTotal(query);
		
		return R.ok().put("rows", goodsLoseList).put("total", total);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Integer id){
		GoodsLoseEntity goodsLose = goodsLoseService.queryObject(id);
		
		return R.ok().put("goodsLose", goodsLose);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody GoodsLoseEntity goodsLose){
		goodsLoseService.save(goodsLose);
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody GoodsLoseEntity goodsLose){
		goodsLoseService.update(goodsLose);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Integer[] ids){
		goodsLoseService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
