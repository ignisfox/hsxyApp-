package com.wfuhui.modules.lose.service;

import java.util.List;
import java.util.Map;

import com.wfuhui.modules.lose.entity.SchoolEntity;

/**
 * 学校
 * 
 */
public interface SchoolService {
	
	SchoolEntity queryObject(Integer id);
	
	List<SchoolEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SchoolEntity school);
	
	void update(SchoolEntity school);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
