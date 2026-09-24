package com.example.TableBook.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
@Builder
public class RestaurantTableResponse {
    Long id;
    int tableNumber;
    int capacity;
    String restaurantName;
}
