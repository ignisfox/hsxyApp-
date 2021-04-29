package com.wfuhui.modules.help.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 会员订单
 * 
 * @author lizhengle
 * @email 2803180149@qq.com
 */
public class MemberOrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//会员id
	private Integer memberId;
	//订单id
	private Integer orderId;

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
	 * 设置：会员id
	 */
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	/**
	 * 获取：会员id
	 */
	public Integer getMemberId() {
		return memberId;
	}
	/**
	 * 设置：订单id
	 */
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	/**
	 * 获取：订单id
	 */
	public Integer getOrderId() {
		return orderId;
	}
}
