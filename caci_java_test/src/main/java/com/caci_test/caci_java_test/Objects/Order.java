package com.caci_test.caci_java_test.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long referenceNo;

    private int numBricks;

    public Order(int numBricks) {
        this.numBricks = numBricks;
    }

    public Order(Long referenceNo, int numBricks) {
        this.referenceNo = referenceNo;
        this.numBricks = numBricks;
    }

    public Order() {
    }

    public Long getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(Long referenceNo) {
        this.referenceNo = referenceNo;
    }

    public int getNumBricks() {
        return numBricks;
    }

    public void setNumBricks(int numBricks) {
        this.numBricks = numBricks;
    }

    @Override
    public String toString() {
        return "Order{" +
                "referenceNo=" + referenceNo +
                ", numBricks=" + numBricks +
                '}';
    }

    // getters and setters
}
