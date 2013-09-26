package org.sgo.projectx.persistence;

import org.sgo.projectx.model.Customer;
import org.sgo.projectx.model.CustomerOrder;
import org.sgo.projectx.model.CustomerOrderLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class Test {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerOrderRepository customerOrderRepository;

    @Transactional
    public void testIt1() {
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

    @Transactional
    public void testIt2() {
        customerOrderRepository.findAll().forEach(order -> {
            order.getCustomerOrderLines().forEach(line -> {
                System.out.println(line.getDescriptionOfGoods());
            });
        });
    }

}
