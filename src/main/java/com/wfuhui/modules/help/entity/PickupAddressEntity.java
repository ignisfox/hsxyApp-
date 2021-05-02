package com.wfuhui.modules.help.entity;

import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class PickupAddressEntity implements Serializable {

   private int id;

    /**
     * 取件地址
     */
   private String address;

    /**
     * 额外配送金额 additional_price
     */
    @Column(name="additional_price")
   private BigDecimal additionalPrice;
}
