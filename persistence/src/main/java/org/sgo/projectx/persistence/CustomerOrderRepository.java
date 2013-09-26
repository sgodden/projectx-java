package org.sgo.projectx.persistence;

import org.sgo.projectx.model.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, String>, org.sgo.projectx.model.CustomerOrderRepository {
}
