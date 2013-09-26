package org.sgo.projectx.persistence_mongo;

import org.sgo.projectx.model.CustomerOrder;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerOrderRepository extends MongoRepository<CustomerOrder, String>, org.sgo.projectx.model.CustomerOrderRepository {
}
