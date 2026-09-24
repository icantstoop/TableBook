package com.example.TableBook.service;

import com.example.TableBook.dto.RestaurantRequest;
import com.example.TableBook.dto.RestaurantResponse;
import com.example.TableBook.entity.Restaurant;
import com.example.TableBook.exception.RestaurantNotFoundException;
import com.example.TableBook.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.management.relation.RelationServiceNotRegisteredException;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService{

    private final RestaurantRepository restaurantRepository;


    @Override
    public List<RestaurantResponse> findAll() {
        List<Restaurant> restaurants = restaurantRepository.findAll();
        List<RestaurantResponse> result = restaurants.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
        return result;

    }

    private RestaurantResponse mapToResponse(Restaurant restaurant){
        return RestaurantResponse.builder()
                .id(restaurant.getId())
                .name(restaurant.getName())
                .address(restaurant.getAddress())
                .description(restaurant.getDescription())
                .openingTime(restaurant.getOpeningTime())
                .closingTime(restaurant.getClosingTime())
                .build();
    }


    @Override
    public RestaurantResponse findById(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new RestaurantNotFoundException("Restaurant not found with " + id + " id"));
        return mapToResponse(restaurant);

    }

    @Override
    public RestaurantResponse create(RestaurantRequest request) {
        Restaurant restaurant = mapToEntity(request);
        Restaurant savedRest = restaurantRepository.save(restaurant);
        return mapToResponse(savedRest);
    }

    private Restaurant mapToEntity(RestaurantRequest request){
        return Restaurant.builder()
                .name(request.getName())
                .address(request.getAddress())
                .description(request.getDescription())
                .openingTime(request.getOpeningTime())
                .closingTime(request.getClosingTime())
                .build();
    }


    @Override
    public RestaurantResponse update(Long id, RestaurantRequest request) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new RestaurantNotFoundException("Restaurant not found with " + id + " id"));
        restaurant.setName(request.getName());
        restaurant.setAddress(request.getAddress());
        restaurant.setDescription(request.getDescription());
        restaurant.setOpeningTime(request.getOpeningTime());
        restaurant.setClosingTime(request.getClosingTime());
        Restaurant updRest = restaurantRepository.save(restaurant);
        return mapToResponse(updRest);
    }

    @Override
    public void delete(Long id) {
        if (!restaurantRepository.existsById(id)){
            throw new RestaurantNotFoundException("Restaurant not found with " + id + " id");
        }

        restaurantRepository.deleteById(id);

    }
}
