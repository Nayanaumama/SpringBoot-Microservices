package com.example.springbatchproject.processor;

import com.example.springbatchproject.entity.CustomerProcessed;
import com.example.springbatchproject.entity.CustomerRaw;
import org.jspecify.annotations.Nullable;
import org.springframework.batch.infrastructure.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CustomerProcessor implements ItemProcessor <CustomerRaw, CustomerProcessed> {

    @Override
    public @Nullable CustomerProcessed process(CustomerRaw item) throws Exception {
        if(!"ACTIVE".equalsIgnoreCase(item.getStatus())) {
            return null;
        }
        Integer age = Integer.parseInt(item.getAgeText());
        BigDecimal salary= new BigDecimal(item.getSalaryText());
        String fullname= item.getFirstName()+""+item.getLastName();
        CustomerProcessed customerProcessed=new CustomerProcessed();
        customerProcessed.setSourceCustomerId(item.getId());
        customerProcessed.setFullName(fullname);
        customerProcessed.setAge(age);
        customerProcessed.setSalary(salary);
        customerProcessed.setCategory("NORMAL");
        customerProcessed.setProcessedStatus("PROCESSED");
       customerProcessed.setCreatedAt(item.getProcessedAt());
        return customerProcessed;
    }
}
