package org.sgodden.tom.model;

public interface ICustomerOrder extends Identity {

    String getOrderNumber();

    void setOrderNumber(String orderNumber);

    String getCustomerReference();

    void setCustomerReference(String customerReference);

}
