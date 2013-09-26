package org.sgo.projectx.persistence_mongo;

import org.sgo.projectx.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String>, org.sgo.projectx.model.CustomerRepository {
}
