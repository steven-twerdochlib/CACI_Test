package com.caci_test.caci_java_test.RestControllers;

import com.caci_test.caci_java_test.Objects.Order;
import com.caci_test.caci_java_test.Repository.OrderRepository;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderRestController {
    @Autowired
    private OrderRepository orderRepository;

    @PostMapping(value = "/saveOrder")
    public Long saveOrders(@PathParam("numBricks") String numBricks) {
        Order newOrder = new Order(Integer.parseInt(numBricks));
        orderRepository.save(newOrder);
        return newOrder.getReferenceNo();
    }

    @GetMapping("/getOrder")
    public Optional<Order> getOrder(@PathParam("referenceNo") Integer referenceNo) {
        return orderRepository.findById(referenceNo);
    }

    @GetMapping("/getAllOrders")
    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    @PostMapping(value = "/updateOrder")
    public Order updateOrder(@PathParam("referenceNo") Long referenceNo, @PathParam("numBricks") Integer numBricks) {
        Order newOrder = new Order(referenceNo, numBricks);
        orderRepository.save(newOrder);
        return newOrder;
    }
}
