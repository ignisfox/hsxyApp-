package com.wfuhui.modules.help.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.wfuhui.modules.member.entity.MemberEntity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;

/**
 * 订单
 * 
 */
@ExcelTarget("orderEntity")
public class OrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	private Integer id;
	// 订单编号
	@Excel(name = "订单编号", width = 30, isImportField = "order_num")
	private String orderNumber;

	private Integer memberId;

	// @ExcelEntity(id = "member")
	private MemberEntity member;

	// 订单金额
	@Excel(name = "订单金额", width = 30, isImportField = "total_amount")
	private BigDecimal totalAmount;
	// 订单状态，1：待付款，2：待抢单，3：已接单，4：已完成
	@Excel(name = "订单状态", width = 30, isImportField = "order_status", replace = { "待付款_1", "待抢单_2", "已接单_3", "已完成_4" })
	private Integer orderStatus;
	// 创建时间
	@Excel(name = "下单时间", width = 30, isImportField = "create_time", exportFormat = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	// 备注
	@Excel(name = "备注", width = 30, isImportField = "remark")
	private String remark;

	/**
	 * 普通订单，预约订单
	 */
	@Excel(name = "订单类型", width = 30, isImportField = "order_type", replace = { "商品订单_1", "快递代取_3", "快递代寄_4",
			"周边代买_5" })
	private Integer orderType;

	@ExcelEntity(name = "服务订单")
	private OrderServiceEntity orderService;

	// 配送员
	@ExcelEntity(name = "配送员")
	private MemberEntity courier;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 设置：订单编号
	 */
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	/**
	 * 获取：订单编号
	 */
	public String getOrderNumber() {
		return orderNumber;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	/**
	 * 设置：订单状态，1：待付款，2：待抢单，3：已接单，4：已完成
	 */
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	/**
	 * 获取：订单状态，1：待付款，2：待抢单，3：已接单，4：已完成
	 */
	public Integer getOrderStatus() {
		return orderStatus;
	}

	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getOrderType() {
		return orderType;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}

	public OrderServiceEntity getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderServiceEntity orderService) {
		this.orderService = orderService;
	}

	public MemberEntity getMember() {
		return member;
	}

	public void setMember(MemberEntity member) {
		this.member = member;
	}

	public MemberEntity getCourier() {
		return courier;
	}

	public void setCourier(MemberEntity courier) {
		this.courier = courier;
	}

}
