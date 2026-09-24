package com.example.TableBook.service;

import com.example.TableBook.dto.RestaurantTableRequest;
import com.example.TableBook.dto.RestaurantTableResponse;

import com.example.TableBook.entity.Restaurant;
import com.example.TableBook.entity.RestaurantTable;
import com.example.TableBook.exception.RestaurantNotFoundException;
import com.example.TableBook.repository.RestaurantRepository;
import com.example.TableBook.repository.RestaurantTableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RestaurantTableServiceImpl implements RestaurantTableService {

    private final RestaurantTableRepository restaurantTableRepository;
    private final RestaurantRepository restaurantRepository;

    @Override
    public List<RestaurantTableResponse> findAll() {
        List<RestaurantTable> tables = restaurantTableRepository.findAll();
        List<RestaurantTableResponse> result = tables.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
        return result;
    }

    private RestaurantTableResponse mapToResponse(RestaurantTable restaurantTable){
        return RestaurantTableResponse.builder()
                .id(restaurantTable.getId())
                .tableNumber(restaurantTable.getTableNumber())
                .capacity(restaurantTable.getCapacity())
                .restaurantName(restaurantTable.getRestaurant().getName())
                .build();
    }


    private RestaurantTable mapToEntity(RestaurantTableRequest request){
        Long idRestaurant = request.getRestaurantId();
        Restaurant restaurant = restaurantRepository.findById(idRestaurant)
                .orElseThrow(() -> new RestaurantNotFoundException("Restaurant not found with " + idRestaurant + " id"));
        return RestaurantTable.builder()
                .tableNumber(request.getTableNumber())
                .capacity(request.getCapacity())
                .restaurant(restaurant)
                .build();
    }

    @Override
    public RestaurantTableResponse findById(Long id) {
        RestaurantTable restaurantTable = restaurantTableRepository.findById(id)
                .orElseThrow(() -> new RestaurantNotFoundException("Table not found with " + id + " id"));
        return mapToResponse(restaurantTable);
    }

    @Override
    public RestaurantTableResponse create(RestaurantTableRequest request) {
        RestaurantTable restaurantTable = mapToEntity(request);
        RestaurantTable savedTable = restaurantTableRepository.save(restaurantTable);
        return mapToResponse(savedTable);
    }

    @Override
    public RestaurantTableResponse update(Long id, RestaurantTableRequest request) {
        RestaurantTable restaurantTable = restaurantTableRepository.findById(id)
                .orElseThrow(() -> new RestaurantNotFoundException("Table not found with " + id + " id"));
        restaurantTable.setTableNumber(request.getTableNumber());
        restaurantTable.setCapacity(request.getCapacity());
        Restaurant restaurant = restaurantRepository.findById(request.getRestaurantId())
                .orElseThrow(() -> new RestaurantNotFoundException("Restaurant not found with " + id + " id"));
        restaurantTable.setRestaurant(restaurant);
        return mapToResponse(restaurantTable);
    }

    @Override
    public void delete(Long id) {
        if (!restaurantTableRepository.existsById(id)){
            throw new RestaurantNotFoundException("Table not found with " + id + " id");
        }
        restaurantTableRepository.deleteById(id);
    }
}
