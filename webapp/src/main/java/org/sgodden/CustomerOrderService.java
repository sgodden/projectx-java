package org.sgodden;

import org.sgo.projectx.model.Customer;
import org.sgo.projectx.model.CustomerOrder;
import org.sgo.projectx.model.CustomerOrderLine;
import org.sgo.projectx.persistence.CustomerOrderRepository;
import org.sgo.projectx.persistence.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Path("/myservice")
@Produces("application/json")
@Service
@Transactional
public class CustomerOrderService {

    @Autowired
    private CustomerOrderRepository customerOrderRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @GET
    public List<CustomerOrderListDto> get() {
        // TODO - replace with use of liquibase
        if (customerOrderRepository.count() == 0) {
            generateOrders();
        }
        // TODO - surely there are map and filter operations coming in JDK 8 which can reduce this to one line
        List<CustomerOrderListDto> ret = new ArrayList<>();
        customerOrderRepository.findAll().forEach(order -> ret.add(new CustomerOrderListDto(order)));
        return ret;
    }

    @GET
    @Path("/{id}")
    public CustomerOrder findOne(@PathParam("id") String id) {
        // TODO - suitable DTO for the entity
        return initialise(customerOrderRepository.findOne(id));
    }

    @POST
    public void save(CustomerOrder order) {
        customerOrderRepository.save(order);
    }

    private CustomerOrder initialise(CustomerOrder order) {
        order.getCustomer().getName();
        order.getCustomerOrderLines().forEach(line -> {});
        return order;
    }

    private void generateOrders() {
        Customer customer = new Customer();
        customer.setName("FINDUS FOOBAR");
        customerRepository.save(customer);

        for (int i = 1; i < 10; i++) {
            CustomerOrder order = new CustomerOrder();
            order.setCustomer(customer);
            order.setOrderNumber("ORD000" + i);
            order.setCustomerReference("CREF000" + i);

            CustomerOrderLine line = new CustomerOrderLine();
            line.setQuantity(new BigDecimal(i));
            line.setDescriptionOfGoods("Description of goods " + i);
            order.addCustomerOrderLine(line);

            customerOrderRepository.save(order);
        }
    }

}
