package com.wfuhui.modules.help.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * 服务订单
 */
public class OrderServiceEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	private Integer id;
	//
	private Integer orderId;

	private String logisticsCompany;
	// 快递单号
	@Excel(name = "快递单号", width = 30, isImportField = "logistics_num")
	private String logisticsNum;
	// 地址
	@Excel(name = "地址", width = 30, isImportField = "address")
	private String address;
	// 描述
	@Excel(name = "描述", width = 30, isImportField = "remark")
	private String remark;
	// 上门时间
	@Excel(name = "上门开始", width = 30, isImportField = "pickup_time")
	private String pickupTime;
	@Excel(name = "上门结束", width = 30, isImportField = "pickup_end_time")
	private String pickupEndTime;
	// 商品名称
	@Excel(name = "商品名称", width = 30, isImportField = "goods_name")
	private String goodsName;
	// 购买数量
	@Excel(name = "购买数量", width = 30, isImportField = "buy_num")
	private Integer buyNum;
	// 付款金额
	@Excel(name = "付款金额", width = 30, isImportField = "pay_price")
	private BigDecimal payPrice;
	@Excel(name = "快递规格", width = 30, isImportField = "express_spec")
	private String expressSpec;
	
	private String realName;
	
	private String mobile;
	
	private String roomNumber;

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
	 * 设置：
	 */
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	/**
	 * 获取：
	 */
	public Integer getOrderId() {
		return orderId;
	}

	public String getLogisticsNum() {
		return logisticsNum;
	}

	public void setLogisticsNum(String logisticsNum) {
		this.logisticsNum = logisticsNum;
	}

	/**
	 * 设置：地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 获取：地址
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 设置：描述
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * 获取：描述
	 */
	public String getRemark() {
		return remark;
	}

	public String getPickupTime() {
		return pickupTime;
	}

	public void setPickupTime(String pickupTime) {
		this.pickupTime = pickupTime;
	}

	/**
	 * 设置：商品名称
	 */
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	/**
	 * 获取：商品名称
	 */
	public String getGoodsName() {
		return goodsName;
	}

	/**
	 * 设置：购买数量
	 */
	public void setBuyNum(Integer buyNum) {
		this.buyNum = buyNum;
	}

	/**
	 * 获取：购买数量
	 */
	public Integer getBuyNum() {
		return buyNum;
	}

	/**
	 * 设置：付款金额
	 */
	public void setPayPrice(BigDecimal payPrice) {
		this.payPrice = payPrice;
	}

	/**
	 * 获取：付款金额
	 */
	public BigDecimal getPayPrice() {
		return payPrice;
	}

	public String getPickupEndTime() {
		return pickupEndTime;
	}

	public void setPickupEndTime(String pickupEndTime) {
		this.pickupEndTime = pickupEndTime;
	}

	public String getExpressSpec() {
		return expressSpec;
	}

	public void setExpressSpec(String expressSpec) {
		this.expressSpec = expressSpec;
	}

	public String getLogisticsCompany() {
		return logisticsCompany;
	}

	public void setLogisticsCompany(String logisticsCompany) {
		this.logisticsCompany = logisticsCompany;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	
}
