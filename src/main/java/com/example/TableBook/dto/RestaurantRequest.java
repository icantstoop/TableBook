package com.example.TableBook.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@Builder
public class RestaurantRequest {
    @NotBlank
    String name;
    @NotBlank
    String address;
    String description;
    LocalTime openingTime;
    LocalTime closingTime;
}
