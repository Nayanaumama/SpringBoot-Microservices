package com.example.kafkaproducer.service;

import com.example.kafkaproducer.model.OrderEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    @Value("${app.kafka.topic}")
    private String topicName;

    private final KafkaTemplate<String, OrderEvent> kafkaTemplate;

    public ProducerService(KafkaTemplate<String, OrderEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    public void sendOrderEvent(OrderEvent orderEvent){
        kafkaTemplate.send(topicName,orderEvent.getOrderId(),orderEvent);
    }

}
