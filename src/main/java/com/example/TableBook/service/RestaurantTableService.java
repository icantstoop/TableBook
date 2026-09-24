package com.example.TableBook.service;

import com.example.TableBook.dto.RestaurantTableRequest;
import com.example.TableBook.dto.RestaurantTableResponse;

import java.util.List;

public interface RestaurantTableService {
    List<RestaurantTableResponse> findAll();
    RestaurantTableResponse findById(Long id);
    RestaurantTableResponse create(RestaurantTableRequest request);
    RestaurantTableResponse update(Long id, RestaurantTableRequest request);
    void delete(Long id);
}
