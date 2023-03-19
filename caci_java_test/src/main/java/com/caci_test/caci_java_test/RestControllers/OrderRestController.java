package com.caci_test.caci_java_test.RestControllers;

import com.caci_test.caci_java_test.Objects.Order;
import com.caci_test.caci_java_test.Repository.OrderRepository;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderRestController {
    @Autowired
    private OrderRepository orderRepository;

    @PostMapping(value = "/saveOrder", produces = MediaType.APPLICATION_JSON_VALUE)
    public Long saveOrders(@PathParam("numBricks") String numBricks) {
        Order newOrder = new Order(Integer.parseInt(numBricks));
        orderRepository.save(newOrder);
        return newOrder.getReferenceNo();
    }

}
