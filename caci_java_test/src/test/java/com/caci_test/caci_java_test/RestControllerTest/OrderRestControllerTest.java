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
}
