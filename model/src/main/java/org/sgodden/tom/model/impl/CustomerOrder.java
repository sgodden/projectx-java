package org.sgodden.tom.model.impl;

import org.sgodden.tom.model.ICustomerOrder;

public class CustomerOrder extends AbstractEntity implements ICustomerOrder {

    private String orderNumber;

    private String customerReference;

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getCustomerReference() {
        return customerReference;
    }

    public void setCustomerReference(String customerReference) {
        this.customerReference = customerReference;
    }
}
