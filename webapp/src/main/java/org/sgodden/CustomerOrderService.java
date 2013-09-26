package org.sgodden;

import org.sgo.projectx.model.CustomerOrder;
import org.sgo.projectx.model.CustomerOrderLine;
import org.sgo.projectx.persistence.CustomerOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.math.BigDecimal;
import java.util.List;

@Path("/myservice")
@Produces("application/json")
@Service
@Transactional
public class CustomerOrderService {

    @Autowired
    private CustomerOrderRepository customerOrderRepository;

    @GET
    public List<CustomerOrder> get() {
        if (customerOrderRepository.count() == 0) {
            generateOrders();
        }
        List<CustomerOrder> ret = customerOrderRepository.findAll();
        // initialise lazy stuff in the transaction - this is crap you would normally map to a specific DTO to return over the wire
        ret.forEach( order -> order.getCustomerOrderLines().forEach( line -> {} ));
        return ret;
    }

    private void generateOrders() {
        for (int i = 1; i < 10; i++) {
            CustomerOrder order = new CustomerOrder();
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
