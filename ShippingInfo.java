package com.kb.shop.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "ShippingInfo")
public class ShippingInfo {

    public ShippingInfo(Long id, String status) {
        this.status = status;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //private Long[] itemIds;
    //private Long orderId;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String status;
    // Order id
    // OrderItem id
    // shippingStatus

}
