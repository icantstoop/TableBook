package com.example.TableBook.controller;

import com.example.TableBook.dto.RestaurantRequest;
import com.example.TableBook.dto.RestaurantResponse;
import com.example.TableBook.entity.Restaurant;
import com.example.TableBook.service.RestaurantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;

    @GetMapping(value = "/api/v1/restaurants")
    public ResponseEntity<List<RestaurantResponse>> findAll(){
        return ResponseEntity.ok(restaurantService.findAll());
    }

    @GetMapping(value = "/api/v1/restaurants/{id}")
    public ResponseEntity<RestaurantResponse> FindById(@PathVariable Long id){
        return ResponseEntity.ok(restaurantService.findById(id));
    }

    @PostMapping(value = "/api/v1/restaurants/{id}")
    public ResponseEntity<RestaurantResponse> create(@Valid @PathVariable RestaurantRequest request){
        RestaurantResponse restaurant = restaurantService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(restaurant);
    }

    @PutMapping(value = "/api/v1/restaurants/{id}")
    public ResponseEntity<RestaurantResponse> update(@PathVariable Long id, @Valid @RequestBody RestaurantRequest request){
        return ResponseEntity.ok(restaurantService.update(id, request));
    }

    @DeleteMapping(value = "/api/v1/restaurant/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        restaurantService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
