package com.example.springbatchproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "customer_processed")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerProcessed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "source_customer_id")
    private Long sourceCustomerId;

    @Column(name = "full_name")
    private String fullName;

    @Column(name="age")
    private Integer age;

    @Column(name="salary")
    private BigDecimal salary;

    @Column(name="category")
    private String category;

    @Column(name="processed_status")
    private String processedStatus;

    @Column(name="created_at")
    private LocalDateTime createdAt;

}



