package org.sgo.projectx.model;

import java.math.BigDecimal;

public class CustomerOrderLine extends AbstractIdentity {
    private BigDecimal quantity;
    private String descriptionOfGoods;

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getDescriptionOfGoods() {
        return descriptionOfGoods;
    }

    public void setDescriptionOfGoods(String descriptionOfGoods) {
        this.descriptionOfGoods = descriptionOfGoods;
    }
}
