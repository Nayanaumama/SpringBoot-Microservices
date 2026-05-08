package com.example.kafkaconsumer.model;

import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderEvent {
    private String orderId;
    private String customerName;
    private BigDecimal amount;
    private String status;

}
