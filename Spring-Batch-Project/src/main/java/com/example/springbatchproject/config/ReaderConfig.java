package com.example.springbatchproject.config;

import com.example.springbatchproject.entity.CustomerRaw;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.batch.infrastructure.item.database.JpaPagingItemReader;
import org.springframework.batch.infrastructure.item.database.builder.JpaPagingItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReaderConfig {

    @Bean
    public JpaPagingItemReader<CustomerRaw> customerReader(EntityManagerFactory entityManagerFactory) {
        return new JpaPagingItemReaderBuilder<CustomerRaw>().name("customerReader")
                .entityManagerFactory(entityManagerFactory)
                .queryString("""
                        Select c from CustomerRaw c where  c.processedFlag='N' order by c.id
                        """)
                .pageSize(2)
                .build();
    }}




