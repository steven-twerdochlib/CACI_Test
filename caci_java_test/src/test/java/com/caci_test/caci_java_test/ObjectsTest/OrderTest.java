package com.caci_test.caci_java_test.ObjectsTest;

import com.caci_test.caci_java_test.Objects.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderTest {

    //Can't test referenceNo variable as this is automatically created when saved to repository.
    @Test
    public void createOrder(){
        Order newOrder1 = new Order(100);
        assertEquals(100, newOrder1.getNumBricks());

        Order newOrder2 = new Order(155);
        assertEquals(155, newOrder2.getNumBricks());
    }
}
