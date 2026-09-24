package com.example.TableBook.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestaurantTableRequest {
    int tableNumber;
    int capacity;
    private Long restaurantId;
}
