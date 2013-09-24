package org.sgo.projectx.persistence;


import org.sgo.projectx.model.impl.CustomerOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
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
    private EntityManagerFactory emf;

    @Test
    @Transactional
    public void basicTest() {
        Assert.assertNotNull(ctx);
        CustomerOrder order = new CustomerOrder();
        order.setCustomerReference("FOO");
        order.setOrderNumber("BAR");
        emf.createEntityManager().persist(order);
        System.out.println(order.getId());
    }

}
