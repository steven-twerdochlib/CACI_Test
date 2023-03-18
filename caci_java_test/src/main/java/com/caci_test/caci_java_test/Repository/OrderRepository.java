package com.caci_test.caci_java_test.Repository;

import com.caci_test.caci_java_test.Objects.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
