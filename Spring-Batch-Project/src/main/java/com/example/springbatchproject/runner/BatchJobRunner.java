package com.example.springbatchproject.runner;

import org.springframework.batch.core.job.Job;


import org.springframework.batch.core.job.JobExecution;
import org.springframework.batch.core.job.parameters.JobParameter;
import org.springframework.batch.core.job.parameters.JobParameters;
import org.springframework.batch.core.job.parameters.JobParametersBuilder;
import org.springframework.batch.core.launch.JobOperator;
import org.springframework.boot.CommandLineRunner;

public class BatchJobRunner implements CommandLineRunner {

    private final JobOperator jobOperator;
    private final Job customerProcessingJob;

    public BatchJobRunner(JobOperator jobOperator, Job customerProcessingJob) {
        this.jobOperator = jobOperator;
        this.customerProcessingJob = customerProcessingJob;
    }

    @Override
    public void run(String... args) throws Exception {
        JobParameters parameters = new JobParametersBuilder()
                .addLong("run.id", System.currentTimeMillis()).toJobParameters();
        JobExecution jobExecution = jobOperator.start(customerProcessingJob, parameters);
        System.out.println(jobExecution.getExitStatus());
    }
}
