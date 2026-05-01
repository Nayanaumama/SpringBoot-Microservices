package com.example.javamailsender.Entity;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomResponse {
    String message;
    String status;

}
