package com.example.springbatchproject.config;

import com.example.springbatchproject.entity.CustomerRaw;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.infrastructure.item.database.JpaPagingItemReader;
import org.springframework.batch.infrastructure.item.database.builder.JpaPagingItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReaderConfig {

    @Bean
    @StepScope
    public JpaPagingItemReader<CustomerRaw> customerReader(EntityManagerFactory entityManagerFactory,
                                                           @Value("#{stepExecutionContext['minId']}") Long minId,
                                                           @Value("#{stepExecutionContext['maxId']}") Long maxId,
                                                           @Value("${app.batch.page-size}") int pageSize)


                                                           {
        return new JpaPagingItemReaderBuilder<CustomerRaw>().name("customerReader")
                .entityManagerFactory(entityManagerFactory)
                .queryString("""
                        Select c from CustomerRaw c where  c.processedFlag='N' order by c.id
                        """)
                .pageSize(pageSize)
                .build();
    }}




