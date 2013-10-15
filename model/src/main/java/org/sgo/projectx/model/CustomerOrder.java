package org.sgo.projectx.model;

import org.hibernate.annotations.Columns;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.Column;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CustomerOrder extends AbstractIdentity {

    private String orderNumber;
    private Customer customerRef;
    private String customerReference;

    @Columns(columns = {@Column(name = "bookingDate"), @Column(name = "bookingTz")})
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime bookingDate;

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

    public DateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(DateTime bookingDate) {
        this.bookingDate = bookingDate;
    }
}
