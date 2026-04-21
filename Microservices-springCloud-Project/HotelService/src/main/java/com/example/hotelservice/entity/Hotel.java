package com.example.hotelservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "hotel",schema = "hotel_service")
public class Hotel {
    @Id
    private String hotelId;
    private String hotelName;
    private String hotelAddress;
    private String about;

}
