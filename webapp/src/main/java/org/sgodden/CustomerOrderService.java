package org.sgodden;

import org.sgo.projectx.model.CustomerOrder;
import org.sgo.projectx.persistence.CustomerOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/myservice")
@Produces("application/json")
@Service
@Transactional
public class CustomerOrderService {

    @Autowired
    private CustomerOrderRepository customerOrderRepository;

    @GET
    public List<CustomerOrder> getStuff() {
        return customerOrderRepository.findAll();
    }

}
