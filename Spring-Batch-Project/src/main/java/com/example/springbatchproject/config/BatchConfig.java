package com.example.springbatchproject.config;

import com.example.springbatchproject.entity.CustomerProcessed;
import com.example.springbatchproject.entity.CustomerRaw;
import com.example.springbatchproject.partition.CustomerPartition;
import com.example.springbatchproject.processor.CustomerProcessor;
import com.example.springbatchproject.writer.CustomerWriter;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.batch.core.job.Job;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.partition.Partitioner;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.Step;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.infrastructure.item.database.JpaItemWriter;
import org.springframework.batch.infrastructure.item.database.JpaPagingItemReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.batch.autoconfigure.BatchProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionManager;

import javax.sql.DataSource;

@Configuration
public class BatchConfig {

    @Value("${app.batch.chunk-size}")
    private int chunkSize;
    @Value("${app.batch.grid-size}")
    private int gridSize;
    @Value("${app.batch.thread-pool.core-size}")
    private int threadPoolSize;
    @Value("${app.batch.thread-pool.max-size}")
    private int maxPoolSize;
    @Value("${app.batch.thread-pool.queue-capacity}")
    private int queueCapacity;


    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    @Bean
    public Job customerProcessingJob(JobRepository jobRepository, Step masterStep) {

        return new JobBuilder("customerProcessingJob", jobRepository).start(masterStep).build();
    }

    @Bean
    public Step masterStep(JobRepository jobRepository,
                           Step customerProcessingStep,
                           Partitioner partitioner,
                           TaskExecutor taskExecutor) {
        return new StepBuilder("masterStep", jobRepository).partitioner("customerProcessingStep", partitioner)
                .step(customerProcessingStep)
                .gridSize(gridSize)
                .taskExecutor(taskExecutor)
                .build();
    }

    @Bean
    public Step customerProcessingStep(JobRepository jobRepository, PlatformTransactionManager transactionManager,
                                       JpaPagingItemReader<CustomerRaw> customerReader,
                                       CustomerProcessor customerProcessor,
                                       CustomerWriter customerWriter) {
        return new StepBuilder("customerProcessingStep", jobRepository)
                .<CustomerRaw, CustomerProcessed>chunk(chunkSize)
                .transactionManager(transactionManager)
                .reader(customerReader)
                .processor(customerProcessor)
                .writer(customerWriter)
                .build();
    }


@Bean
public Partitioner partitioner(EntityManagerFactory entityManagerFactory)
{
    return new CustomerPartition(entityManagerFactory);
}
@Bean
public TaskExecutor taskExecutor()
{

    ThreadPoolTaskExecutor taskExecutor=new ThreadPoolTaskExecutor();
    taskExecutor.setCorePoolSize(threadPoolSize);
    taskExecutor.setMaxPoolSize(maxPoolSize);
    taskExecutor.setQueueCapacity(queueCapacity);
    taskExecutor.setThreadNamePrefix("customerProcessingTask-");
    taskExecutor.initialize();
    return taskExecutor;
}
}