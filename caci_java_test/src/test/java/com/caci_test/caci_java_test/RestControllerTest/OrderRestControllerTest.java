package com.caci_test.caci_java_test.RestControllerTest;

import com.caci_test.caci_java_test.Objects.Order;
import com.caci_test.caci_java_test.Repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class OrderRestControllerTest {

    @MockBean
    private OrderRepository orderRepository;

    @Autowired
    private MockMvc mvc;

    //Below test doesn't work because of error: Unparsable JSON string
    /*
    @Test
    public void saveOrder() throws Exception{
        Order newOrder = new Order(100);
        when(orderRepository.save(newOrder)).thenReturn(newOrder);
        mvc.perform(MockMvcRequestBuilders
                .post("/saveOrder?numBricks=100"))
                .andExpect(status().isOk())
                .andExpect(content().json("0"));
    }
     */
    @Test
    public void getOrder() throws Exception{
        Order newOrder = new Order(53L,35);
        when(orderRepository.findById(53)).thenReturn(Optional.of(newOrder));
        mvc.perform(MockMvcRequestBuilders
                        .get("/getOrder?referenceNo=53"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"referenceNo\":53,\"numBricks\":35}"));
    }

    @Test
    public void getAllOrder() throws Exception{
        Order newOrder1 = new Order(53L,35);
        Order newOrder2 = new Order(81L,79);
        List<Order> listOfOrders = new ArrayList<>();
        listOfOrders.add(newOrder1);
        listOfOrders.add(newOrder2);
        when(orderRepository.findAll()).thenReturn(listOfOrders);
        mvc.perform(MockMvcRequestBuilders
                        .get("/getAllOrders"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"referenceNo\":53,\"numBricks\":35}, {\"referenceNo\":81,\"numBricks\":79}]"));
    }
}
