package com.wfuhui.modules.lose.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wfuhui.modules.lose.dao.SchoolDao;
import com.wfuhui.modules.lose.entity.SchoolEntity;
import com.wfuhui.modules.lose.service.SchoolService;



@Service("schoolService")
public class SchoolServiceImpl implements SchoolService {
	@Autowired
	private SchoolDao schoolDao;
	
	@Override
	public SchoolEntity queryObject(Integer id){
		return schoolDao.queryObject(id);
	}
	
	@Override
	public List<SchoolEntity> queryList(Map<String, Object> map){
		return schoolDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return schoolDao.queryTotal(map);
	}
	
	@Override
	public void save(SchoolEntity school){
		schoolDao.save(school);
	}
	
	@Override
	public void update(SchoolEntity school){
		schoolDao.update(school);
	}
	
	@Override
	public void delete(Integer id){
		schoolDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		schoolDao.deleteBatch(ids);
	}
	
}
