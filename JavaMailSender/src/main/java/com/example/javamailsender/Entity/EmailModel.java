package com.example.javamailsender.Entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmailModel {
    String to;
    String subject;
    String htmlmessage;
}
