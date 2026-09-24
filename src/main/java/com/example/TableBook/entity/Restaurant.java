package com.example.TableBook.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "restaurants")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "name")
    String name;
    @Column(name = "address")
    String address;
    @Column(name = "description")
    String description;
    @Column(name = "opening_time")
    LocalTime openingTime;
    @Column(name = "closing_time")
    LocalTime closingTime;
}
