package com.wfuhui.modules.help.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.io.Serializable;

@Data
public class OrderSpecEntity implements Serializable {

    private int id;

    /**
     * 订单id
     */
    @Excel(name = "订单id",isImportField = "order_id")
    private int orderId;

    /**
     * 取件地址
     */
    @Excel(name = "取件地址",isImportField = "express_address")
    private String expressAddress;

    /**
     * 取件码
     */
    @Excel(name = "取件码",isImportField = "express_code")
    private String expressCode;

    /**
     * 收件联系人
     */
    private String person;

    /**
     * 收件人电话
     */
    private String mobile;

    /**
     * 规格((小，中，大，超大))
     */
    private String specs;

    /**
     * 规格价格(2,4,8,18)
     */
    @Excel(name = "规格价格",isImportField = "specs_price")
    private String specsPrice;

    /**
     * 加急金额
     */
    @Excel(name = "加急金额",isImportField = "extra_price")
    private int extraPrice;

    /**
     * 备注
     */
    private String remark;

    /**
     * 上门时间
     */
    @Excel(name = "上门时间",isImportField = "pickup_time")
    private String pickupTime;

    /**
     * 上门时间
     */
    @Excel(name = "上门时间",isImportField = "pickup_end_time")
    private String pickupEndTime;

    /**
     * 发布订单时间
     */
    @Excel(name = "发布订单时间",isImportField = "create_time")
    private String createTime;


}
