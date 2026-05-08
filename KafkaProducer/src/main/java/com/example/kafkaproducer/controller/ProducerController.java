package com.example.kafkaproducer.controller;


import com.example.kafkaproducer.model.OrderEvent;
import com.example.kafkaproducer.service.ProducerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class ProducerController {

    private final ProducerService producerService;

    public ProducerController(ProducerService producerService) {
        this.producerService = producerService;
    }
    @PostMapping("/publish")
    public ResponseEntity<String> publishOrder(@RequestBody OrderEvent orderEvent){
    producerService.sendOrderEvent(orderEvent);
        return ResponseEntity.ok("Order Published");
    }
}
