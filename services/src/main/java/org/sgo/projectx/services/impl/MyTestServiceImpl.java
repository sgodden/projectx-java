package org.sgo.projectx.services.impl;

import org.sgo.projectx.model.Customer;
import org.sgo.projectx.model.CustomerOrder;
import org.sgo.projectx.model.CustomerOrderLine;
import org.sgo.projectx.persistence.CustomerOrderRepository;
import org.sgo.projectx.persistence.CustomerRepository;
import org.sgo.projectx.services.MyTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class MyTestServiceImpl implements MyTestService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerOrderRepository customerOrderRepository;

    @Override
    public void doSomeStuff() {
        Customer customer = new Customer();
        customer.setName("Foo Customer");
        customerRepository.save(customer);

        CustomerOrder order = new CustomerOrder();
        order.setCustomerReference("FOO");
        order.setOrderNumber("BAR");
        order.setCustomer(customer);

        CustomerOrderLine line = new CustomerOrderLine();
        line.setQuantity(new BigDecimal("5"));
        line.setDescriptionOfGoods("Foobars");
        order.addCustomerOrderLine(line);

        customerOrderRepository.save(order);

        order = customerOrderRepository.findOne(order.getId());
        System.out.println(order.getCustomer().getName());

        order.getCustomerOrderLines().forEach((item) -> System.out.print(item.getDescriptionOfGoods()) );

        System.out.println(customerOrderRepository.findOne(order.getId()).getCustomer().getName());
    }

    @Override
    public void doMoreStuff() {
        customerOrderRepository.findAll().forEach(order -> {
            order.getCustomerOrderLines().forEach(line -> {
                System.out.println(line.getDescriptionOfGoods());
            });
        });
    }
}
