package com.example.userservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "user", schema = "userService")
public class User {
           @Id
           @Column(name = "user_id")
           private String userId;
           @Column(name = "name")
           private String name;
           @Column(name = "email")
           private String email;
           @Column(name = "about")
           private String about;
}
