package com.example.kafkaproducer.model;

import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderEvent {
    private String orderId;
    private String customerName;
    private BigDecimal amount;
    private String status;

}
