package org.sgo.projectx.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CustomerOrder extends AbstractIdentity {

    private String orderNumber;
    private Customer customerRef;
    private String customerReference;

    private Set<CustomerOrderLine> customerOrderLines = new HashSet<CustomerOrderLine>();

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

    public Set<CustomerOrderLine> getCustomerOrderLines() {
        return Collections.unmodifiableSet(customerOrderLines);
    }

    public void addCustomerOrderLine(CustomerOrderLine line) {
        customerOrderLines.add(line);
    }

    public void removeCustomerOrderLine(CustomerOrderLine line) {
        customerOrderLines.remove(line);
    }
}
