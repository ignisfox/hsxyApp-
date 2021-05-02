package com.wfuhui.modules.help.entity;

import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class DormitoryBuildingEntity implements Serializable {

    private int id;

    /**
     *宿舍区域(01西区，02东区，03T区)
     */
    @Column(name="area")
    private String area;

    /**
     * 宿舍楼地址
     */
    @Column(name="address")
    private String address;

    /**
     * 宿舍楼配送额外金额
     */
    @Column(name="dormitory_price")
    private BigDecimal dormitoryPrice;
}
