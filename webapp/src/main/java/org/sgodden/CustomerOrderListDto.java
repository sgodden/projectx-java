package org.sgodden;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.sgo.projectx.model.CustomerOrder;

import java.io.Serializable;

public class CustomerOrderListDto implements Serializable {
    private String id;
    private String orderNumber;
    private String customerReference;

    public CustomerOrderListDto(CustomerOrder order) {
        Mapper mapper = new DozerBeanMapper();
        mapper.map(order, this);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
