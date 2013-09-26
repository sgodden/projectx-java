package org.sgo.projectx.model;

import java.util.List;

public interface CustomerOrderRepository {
    public List<CustomerOrder> findAll();
}
