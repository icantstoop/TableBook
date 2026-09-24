package com.example.TableBook.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalTime;

@Getter
@Setter
@Builder
public class RestaurantResponse {
    Long id;
    String name;
    String address;
    String description;
    LocalTime openingTime;
    LocalTime closingTime;
}
