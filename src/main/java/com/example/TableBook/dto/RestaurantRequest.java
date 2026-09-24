package com.example.TableBook.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalTime;

@Getter
@Setter
public class RestaurantRequest {
    @NotBlank
    String name;
    @NotBlank
    String address;
    String description;
    LocalTime openingTime;
    LocalTime closingTime;
}
