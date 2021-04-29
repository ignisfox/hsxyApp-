package com.wfuhui.modules.lose.api;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wfuhui.common.annotation.AuthIgnore;
import com.wfuhui.common.annotation.Login;
import com.wfuhui.common.utils.Query;
import com.wfuhui.common.utils.R;
import com.wfuhui.modules.lose.entity.GoodsLoseEntity;
import com.wfuhui.modules.lose.service.GoodsLoseService;

/**
 * 失物招领
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/api/goodslose")
public class ApiGoodsLoseController {
	
	@Autowired
	private GoodsLoseService goodsLoseService;

	@AuthIgnore
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params) {
		Query query = new Query(params);
		
		List<GoodsLoseEntity> goodsLoseList = goodsLoseService.queryList(query);
		
		return R.ok().put("goodsLoseList", goodsLoseList);
	}
	
	@Login
	@RequestMapping("/add")
	public R add(@RequestBody GoodsLoseEntity goodsLose, @RequestAttribute("userId") Integer userId) {
		goodsLose.setUserId(userId);
		goodsLose.setCreateTime(new Date());
		goodsLoseService.save(goodsLose);
		return R.ok("发布成功");
	}
}
