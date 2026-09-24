package com.example.TableBook.service;

import com.example.TableBook.dto.RestaurantRequest;
import com.example.TableBook.dto.RestaurantResponse;

import java.util.List;

public interface RestaurantService {
    public List<RestaurantResponse> findAll();
    public RestaurantResponse findById(Long id);
    public RestaurantResponse create(RestaurantRequest request);
    public RestaurantResponse update(Long id, RestaurantRequest request);
    public void delete(Long id);
}
