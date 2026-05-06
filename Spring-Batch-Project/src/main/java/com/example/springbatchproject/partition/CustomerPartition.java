package com.example.springbatchproject.partition;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.batch.core.partition.Partitioner;
import org.springframework.batch.infrastructure.item.ExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
public class CustomerPartition implements Partitioner {

    private final EntityManagerFactory entityManagerFactory;

    public CustomerPartition(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }


    @Override
    public Map<String, ExecutionContext> partition(int gridSize) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Long minId = entityManager.createQuery("select min(id) from CustomerRaw where processedFlag='N'", Long.class).getSingleResult();
            Long maxId = entityManager.createQuery("select max(id) from CustomerRaw where processedFlag='N'", Long.class).getSingleResult();
            Map<String, ExecutionContext> partitions = new HashMap<>();
            if (minId == null && maxId == null) {
                return partitions;
            }
            long targetSize = ((maxId - minId) / gridSize) + 1;
            long start = minId;
            long end = start + targetSize - 1;
            int partitionId = 0;
            while (start <= maxId) {
                ExecutionContext executionContext = new ExecutionContext();
                executionContext.putLong("minId", start);
                executionContext.putLong("maxId", Math.min(end, maxId));
                partitions.put("partition" + partitionId, executionContext);
                start += targetSize;
                end += targetSize;
                partitionId++;
            }
            return partitions;
        } finally {

            entityManager.close();
        }
    }
}

