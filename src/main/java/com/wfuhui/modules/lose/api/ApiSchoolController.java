package com.wfuhui.modules.lose.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wfuhui.common.utils.R;
import com.wfuhui.modules.lose.entity.SchoolEntity;
import com.wfuhui.modules.lose.service.SchoolService;

@RestController
@RequestMapping("/api/school")
public class ApiSchoolController {
	
	@Autowired
	public SchoolService schoolService;
	
	@RequestMapping("/list")
	public R list() {
		List<SchoolEntity> schoolList = schoolService.queryList(null);
		return R.ok().put("schoolList", schoolList);
	}
}
