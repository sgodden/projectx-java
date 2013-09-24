package org.sgo.projectx.persistence;


import org.sgo.projectx.model.Customer;
import org.sgo.projectx.model.CustomerOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@ContextConfiguration(locations={"classpath:org/sgo/projectx/persistence/beans.xml"})
public class BasicTestIT extends AbstractTestNGSpringContextTests {

    @Autowired
    private ApplicationContext ctx;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerOrderRepository customerOrderRepository;

    @Test
    public void basicTest() {
        Assert.assertNotNull(ctx);

        Customer customer = new Customer();
        customer.setName("Foo Customer");
        customerRepository.save(customer);

        CustomerOrder order = new CustomerOrder();
        order.setCustomerReference("FOO");
        order.setOrderNumber("BAR");
        order.setCustomer(customer);
        customerOrderRepository.save(order);

        System.out.println(order.getId());

        System.out.println(customerOrderRepository.findOne("1").getCustomer().getName());
    }

}
