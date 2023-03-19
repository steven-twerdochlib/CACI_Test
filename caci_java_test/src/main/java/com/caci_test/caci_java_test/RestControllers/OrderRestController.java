package com.caci_test.caci_java_test.RestControllers;

import com.caci_test.caci_java_test.Objects.Fulfilled;
import com.caci_test.caci_java_test.Objects.Order;
import com.caci_test.caci_java_test.Repository.OrderRepository;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public Order getOrder(@PathParam("referenceNo") Integer referenceNo) {
        return orderRepository.getById(referenceNo);
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

    @PostMapping(value = "/dispatchedOrder")
    public Order dispatchedOrder(@PathParam("referenceNo") Integer referenceNo) {
        Optional<Order> newOrder1 = orderRepository.findById(referenceNo);
        if(newOrder1.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Reference Number!");
        }
        else{
            Order newOrderObject = orderRepository.getById(referenceNo);
            newOrderObject.setFulfilled(Fulfilled.DISPATCHED);
            orderRepository.save(newOrderObject);
            return newOrderObject;
        }
    }
}
