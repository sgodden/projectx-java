package org.sgo.projectx.persistence;

import org.sgo.projectx.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
