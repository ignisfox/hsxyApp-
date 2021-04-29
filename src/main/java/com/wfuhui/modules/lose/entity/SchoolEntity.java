package com.wfuhui.modules.lose.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 学校
 * 
 */
public class SchoolEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//学校名称
	private String schoolName;
	//排序
	private Integer sort;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：学校名称
	 */
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	/**
	 * 获取：学校名称
	 */
	public String getSchoolName() {
		return schoolName;
	}
	/**
	 * 设置：排序
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	/**
	 * 获取：排序
	 */
	public Integer getSort() {
		return sort;
	}
}
