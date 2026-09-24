package com.example.TableBook.service;

import com.example.TableBook.dto.RestaurantRequest;
import com.example.TableBook.dto.RestaurantResponse;

import java.util.List;

public interface RestaurantService {
    List<RestaurantResponse> findAll();
    RestaurantResponse findById(Long id);
    RestaurantResponse create(RestaurantRequest request);
    RestaurantResponse update(Long id, RestaurantRequest request);
    void delete(Long id);
}
