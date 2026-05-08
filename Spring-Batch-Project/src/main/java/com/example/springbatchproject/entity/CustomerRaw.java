package com.example.springbatchproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer_raw")
public class CustomerRaw {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age_text")
    private String ageText;

    @Column(name = "salary_text")
    private String salaryText;

    @Column(name = "status")
    private String status;

    @Column(name = "processed_flag")
    private String processedFlag;

    @Column(name = "processed_at")
    private OffsetDateTime processedAt;

    @Column(name = "processing_run_id")
    private String processingRunId;

}
