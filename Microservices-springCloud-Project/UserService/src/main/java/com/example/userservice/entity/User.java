package com.example.userservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

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
           @Transient//not to store in database .Jpa will ignore this feild
           private List<Rating> Rating=new ArrayList<>();

}
