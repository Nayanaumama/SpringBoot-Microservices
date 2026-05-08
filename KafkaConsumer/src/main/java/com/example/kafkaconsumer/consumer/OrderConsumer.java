package com.example.kafkaconsumer.consumer;

import com.example.kafkaconsumer.model.OrderEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OrderConsumer {
    @KafkaListener(topics = "${app.kafka.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(OrderEvent event) {
        System.out.println("Received message: " + event.getCustomerName() +" "+ event.getAmount()+" " + event.getStatus()+" " + event.getOrderId());

    }
}
