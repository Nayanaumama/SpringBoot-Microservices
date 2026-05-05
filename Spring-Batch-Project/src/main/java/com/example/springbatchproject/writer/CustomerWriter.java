package com.example.springbatchproject.writer;

import com.example.springbatchproject.entity.CustomerProcessed;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.batch.infrastructure.item.Chunk;
import org.springframework.batch.infrastructure.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerWriter implements ItemWriter<CustomerProcessed> {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void write(Chunk<? extends CustomerProcessed> chunk) throws Exception {
        for(CustomerProcessed item:chunk) {
            entityManager.persist(item);
        }
        List<Long> sourceIds=chunk.getItems().stream().map(CustomerProcessed::getSourceCustomerId).toList();
        entityManager.createQuery("""
UPDATE CustomerRaw c
SET c.processedFlag='Y',
c.processedAt=CURRENT_TIMESTAMP
 where c.id IN :ids""").setParameter("ids",sourceIds).executeUpdate();
        entityManager.flush();
        entityManager.clear();

    }
}
