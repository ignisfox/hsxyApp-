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
import com.wfuhui.modules.lose.entity.SchoolEntity;
import com.wfuhui.modules.lose.service.SchoolService;


/**
 * 学校
 * 
 */
@RestController
@RequestMapping("school")
public class SchoolController {
	@Autowired
	private SchoolService schoolService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<SchoolEntity> schoolList = schoolService.queryList(query);
		int total = schoolService.queryTotal(query);
		
		return R.ok().put("rows", schoolList).put("total", total);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Integer id){
		SchoolEntity school = schoolService.queryObject(id);
		
		return R.ok().put("school", school);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody SchoolEntity school){
		schoolService.save(school);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody SchoolEntity school){
		schoolService.update(school);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Integer[] ids){
		schoolService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
