package com.wfuhui.modules.lose.dao;

import org.apache.ibatis.annotations.Mapper;

import com.wfuhui.modules.lose.entity.GoodsLoseEntity;
import com.wfuhui.modules.sys.dao.BaseDao;

/**
 * 失物招领
 * 
 */
@Mapper
public interface GoodsLoseDao extends BaseDao<GoodsLoseEntity> {
	
}
