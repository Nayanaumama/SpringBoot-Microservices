package com.example.springbatchproject.config;

import com.example.springbatchproject.entity.CustomerProcessed;
import com.example.springbatchproject.entity.CustomerRaw;
import com.example.springbatchproject.processor.CustomerProcessor;
import com.example.springbatchproject.writer.CustomerWriter;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.batch.core.job.Job;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.Step;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.infrastructure.item.database.JpaItemWriter;
import org.springframework.batch.infrastructure.item.database.JpaPagingItemReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.batch.autoconfigure.BatchProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionManager;

@Configuration
public class BatchConfig {

    @Value("${app.batch.chunk-size}")
    private int chunkSize;

    //    @Bean
//    public PlatformTransactionManager transactionManager(EntityManagerFactory    entityManagerFactory) {
//        return new JpaTransactionManager(entityManagerFactory);
//    }
    @Bean
    public Job customerProcessingJob(JobRepository jobRepository, Step customerProcessingStep)
    {

        return new JobBuilder("customerProcessingJob",jobRepository).start(customerProcessingStep).build();
    }


@Bean
public Step customerProcessingStep(JobRepository jobRepository,PlatformTransactionManager  transactionManager,
                                   JpaPagingItemReader<CustomerRaw>customerReader,
                                   CustomerProcessor customerProcessor,
                                   CustomerWriter customerWriter)
{
    return new StepBuilder("customerProcessingStep", jobRepository)
            .<CustomerRaw, CustomerProcessed>chunk(chunkSize)
            .transactionManager(transactionManager)
            .reader(customerReader)
            .processor(customerProcessor)
            .writer(customerWriter)
            .build();
}
}