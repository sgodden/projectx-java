package org.sgo.projectx.model;

public class CustomerOrder extends AbstractIdentity {

    private String orderNumber;
    private Customer customerRef;

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

    public Customer getCustomer() {
        return customerRef;
    }

    public void setCustomer(Customer customerRef) {
        this.customerRef = (Customer) customerRef;
    }
}
